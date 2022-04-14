package com.company;

import java.util.Objects;

abstract class Creator {
    private Persons person;
    private Place place;
    private Condition condition;
    private Stuff stuff;
    public Creator(Persons person,
                   Place place,
                   Condition condition,
                   Stuff stuff) {
        this.person = person;
        this.place = place;
        this.condition = condition;
        this.stuff = stuff;
    }

    public Persons getPerson() {
        return person;
    }

    public Place getPlace() {
        return place;
    }

    public Condition getCondition() {
        return condition;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    @Override
    public String toString() {
        return person.getTitle() +
                " " + place.getTitle() +
                " " + condition.getTitle() +
                " " + stuff.getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        return ((Creator) o).person == person
                && ((Creator) o).place == place
                && ((Creator) o).condition == condition
                && ((Creator) o).stuff == stuff;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(toString());
    }

}

class Police extends Creator implements PoliceActions {
    public Police(Place place,
                  Condition condition,
                  Stuff stuff) {
        super(null, place, condition, stuff);
        setPerson(Persons.Policemen);
    }

    @Override
    public String out() {
        return ActionsMessage.Out.getTitle();
    }

    @Override
    public String stopped() {
        return ActionsMessage.Stopped.getTitle();
    }

    @Override
    public String applied() {
        return ActionsMessage.Applied.getTitle();
    }

    @Override
    public String ready() {
        return ActionsMessage.Ready.getTitle();
    }

    @Override
    public String shot() {
        return ActionsMessage.Shot.getTitle();
    }

    @Override
    public String back() {
        return ActionsMessage.Back.getTitle();
    }

    @Override
    public String rushed() {
        return ActionsMessage.Rushed.getTitle();
    }

    @Override
    public String turnedInto() {
        return ActionsMessage.TurnedInto.getTitle();
    }

    @Override
    public String down() {
        return ActionsMessage.Down.getTitle();
    }

    @Override
    public String couldBe() {
        return ActionsMessage.CouldBe.getTitle();
    }
}

class Dwarfs extends Creator implements DwarfActions {
    public Dwarfs(Persons person,
                  Place place,
                  Condition condition,
                  Stuff stuff) {
        super(person, place, condition, stuff);
    }

    @Override
    public String rangOut() {
        return ActionsMessage.RangOut.getTitle();
    }

    @Override
    public String say() {
        return ActionsMessage.Say.getTitle();
    }

    @Override
    public String around() {
        return ActionsMessage.Around.getTitle();
    }

    @Override
    public String saw2() {
        return ActionsMessage.Saw2.getTitle();
    }

    @Override
    public String comeBack() {
        return ActionsMessage.ComeBack.getTitle();
    }

    @Override
    public String saw1() {
        return ActionsMessage.Saw1.getTitle();
    }

    @Override
    public String enabled() {
        return ActionsMessage.Enabled.getTitle();
    }

    @Override
    public String heard() {
        return ActionsMessage.Heard.getTitle();
    }

}

