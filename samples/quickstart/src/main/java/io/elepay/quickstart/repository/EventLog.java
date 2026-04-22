package io.elepay.quickstart.repository;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Bounded newest-first ring buffer of notable events in the quickstart.
 *
 * <p>Each {@link Entry} carries an {@link Origin}: verified inbound webhook,
 * merchant-triggered action, reconciliation refresh, local create, or
 * rejected-signature delivery. Entries may carry a {@code resourceTag}
 * (e.g. {@code charge.demo-123}) so the UI can group events per order.
 *
 * <p>Not a {@link org.springframework.stereotype.Repository} because it is
 * not keyed by id — it is a chronological log.
 */
@Component
public class EventLog {

    public static final int CAPACITY = 200;

    public enum Origin { CREATE, WEBHOOK, REFRESH, ACTION, REJECT }

    public static class Entry {
        public final Instant receivedAt;
        public final Origin  origin;
        public final boolean verified;
        public final String  resourceTag;
        public final String  summary;
        public final String  body;

        public Entry(Instant receivedAt, Origin origin, boolean verified,
                     String resourceTag, String summary, String body) {
            this.receivedAt  = receivedAt;
            this.origin      = origin;
            this.verified    = verified;
            this.resourceTag = resourceTag == null ? "" : resourceTag;
            this.summary     = summary == null ? "" : summary;
            this.body        = body == null ? "" : body;
        }

        public String  getReceivedAt()  { return receivedAt.toString(); }
        public String  getOrigin()      { return origin.name().toLowerCase(); }
        public boolean isVerified()     { return verified; }
        public String  getResourceTag() { return resourceTag; }
        public String  getSummary()     { return summary; }
        public String  getBody()        { return body; }

        public static Entry create(String tag, String summary, String body) {
            return new Entry(Instant.now(), Origin.CREATE,  true,  tag, summary, body);
        }
        public static Entry webhook(String tag, String summary, String body) {
            return new Entry(Instant.now(), Origin.WEBHOOK, true,  tag, summary, body);
        }
        public static Entry reject(String tag, String summary, String body) {
            return new Entry(Instant.now(), Origin.REJECT,  false, tag, summary, body);
        }
        public static Entry refresh(String tag, String summary, String body) {
            return new Entry(Instant.now(), Origin.REFRESH, true,  tag, summary, body);
        }
        public static Entry action(String tag, String summary, String body) {
            return new Entry(Instant.now(), Origin.ACTION,  true,  tag, summary, body);
        }
    }

    private final Deque<Entry> entries = new ArrayDeque<>();

    public synchronized void record(Entry e) {
        entries.addFirst(e);
        while (entries.size() > CAPACITY) entries.removeLast();
    }

    public synchronized List<Entry> snapshot() {
        return new ArrayList<>(entries);
    }

    public synchronized List<Entry> byTag(String tag) {
        if (tag == null || tag.isEmpty()) return new ArrayList<>();
        List<Entry> out = new ArrayList<>();
        for (Entry e : entries) if (tag.equals(e.resourceTag)) out.add(e);
        return out;
    }
}
