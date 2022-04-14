package com.company;

enum Persons {
    Pilulkin("Пилюлькин"),
    Korotishki("Коротышки"),
    Kolosok("Колосок"),
    Znayka("Знайка"),
    Policemen("пятеро полицейских");
    private final String title;
    Persons(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

enum Place {
    Aside("в стороне"),
    Back("назад"),
    Hill("из-за холма"),
    Down("вниз"),
    InAir("в воздухе");
    private final String title;
    Place(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

enum Condition {
    Running("бегом"),
    Unexpected("неожиданно"),
    Quickly("быстро"),
    Hesitate("ни секунды не медля"),
    Speed("со страшной скоростью"),
    TheSameTime("в тот же миг"),
    NotSuspected("не подозревая");

    private final String title;
    Condition(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

enum Stuff {
    Shots("выстрелы"),
    Guns("к ружьям"),
    Device("прибор невесомости"),
    Power("возникшая реактивная сила"),
    Dot("в едва заметные точки"),
    ZeroGravity("в невесомости");
    private final String title;
    Stuff(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

enum ActionsMessage {
    Say("сказал"),
    Heard("услышали"),
    Around("обернулись"),
    Saw2("увидели"),
    ComeBack("возвращался"),
    Out("выскочили"),
    Down("спустились вниз"),
    Stopped("остановились"),
    Applied("приложились"),
    Ready("готовясь выстрелить"),
    Saw1("увидел"),
    Enabled("включил"),
    RangOut("раздался залп"),
    Shot("выстрелили"),
    Back("понеслись назад"),
    Rushed("помчались"),
    TurnedInto("превратились"),
    CouldBe("могут оказаться");
    private final String title;
    ActionsMessage(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

