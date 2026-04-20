class BrowserHistory {
    private Deque<String> historyStack = new ArrayDeque<>();
    private Deque<String> forwardStack = new ArrayDeque<>();

    public BrowserHistory(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        historyStack.push(url);
        forwardStack.clear();
    }

    public String back(int steps) {
        while (steps > 0 && historyStack.size() > 1) {
            forwardStack.push(historyStack.pop());
            steps--;
        }
        return historyStack.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && !forwardStack.isEmpty()) {
            historyStack.push(forwardStack.pop());
            steps--;
        }
        return historyStack.peek();
    }
}