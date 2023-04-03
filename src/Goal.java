record Goal(Player scorer, int time) {

    @Override
    public String toString() {
        return "Goal scored by " + scorer.getName() + " at " + time + " minutes.";
    }
}