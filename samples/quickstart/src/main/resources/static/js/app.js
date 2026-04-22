// Global submit-button loading affordance. Every <form> in the app goes
// through a server round-trip that may include an SDK call to elepay; that
// can take a noticeable fraction of a second. Without feedback, users
// double-click. This script intercepts submissions, disables the submit
// button, and swaps its label for "<original>…", then lets the browser
// navigate as normal.
(function () {
    function attach(form) {
        if (form.__loadingWired) return;
        form.__loadingWired = true;
        form.addEventListener('submit', function () {
            // Remember all submit buttons inside this form; browsers only
            // activate one at a time, but some forms have several.
            var buttons = form.querySelectorAll('button[type="submit"], button:not([type])');
            buttons.forEach(function (btn) {
                if (btn.disabled) return;
                btn.__originalLabel = btn.textContent;
                btn.textContent = btn.textContent.trim() + ' …';
                btn.disabled = true;
                btn.classList.add('loading');
            });
            // If the navigation is cancelled (validation failure, pagehide),
            // restore the button on pageshow so the user can retry.
            window.addEventListener('pageshow', function restore() {
                buttons.forEach(function (btn) {
                    if (btn.__originalLabel !== undefined) {
                        btn.textContent = btn.__originalLabel;
                        btn.disabled = false;
                        btn.classList.remove('loading');
                    }
                });
                window.removeEventListener('pageshow', restore);
            });
        });
    }

    document.addEventListener('DOMContentLoaded', function () {
        document.querySelectorAll('form').forEach(attach);
    });
})();
