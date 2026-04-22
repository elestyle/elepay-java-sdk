package com.example;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.springframework.stereotype.Component;

/** Fixed-capacity ring buffer of webhook events, newest first. In-memory only. */
@Component
public class EventStore {

    public static final int CAPACITY = 50;

    public static class Entry {
        public final Instant receivedAt;
        public final boolean verified;
        public final String summary;
        public final String body;

        public Entry(Instant receivedAt, boolean verified, String summary, String body) {
            this.receivedAt = receivedAt;
            this.verified = verified;
            this.summary = summary;
            this.body = body;
        }

        public String getReceivedAt() { return receivedAt.toString(); }
        public boolean isVerified() { return verified; }
        public String getSummary() { return summary; }
        public String getBody() { return body; }
    }

    private final Deque<Entry> entries = new ArrayDeque<>();

    public synchronized void record(Entry e) {
        entries.addFirst(e);
        while (entries.size() > CAPACITY) entries.removeLast();
    }

    public synchronized List<Entry> snapshot() {
        return new ArrayList<>(entries);
    }
}
