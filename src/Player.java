final class Player {
    private String name;
    private String age;
    private PlayerPosition position;
    private int number;
    private Team team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number < 0 || number > 99) {
            throw new IllegalArgumentException("The player number must be between 1 and 99");
        }
        this.number = number;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}