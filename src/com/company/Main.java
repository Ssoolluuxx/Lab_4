package com.company;

public class Main {
    static Dwarfs dwarfs = new Dwarfs(Persons.Pilulkin,
            Place.Aside,
            Condition.Unexpected,
            Stuff.Shots);

    static Police police = new Police(
            Place.Hill,
            Condition.TheSameTime,
            Stuff.Guns);

    interface ChangeScene {
        void changeDwarfsScene(Persons person,
                               Place place,
                               Condition condition,
                               Stuff stuff);

        void changePoliceScene(Place place,
                               Condition condition,
                               Stuff stuff);
    }

    static class EmptyDwarfField extends RuntimeException {
        public EmptyDwarfField(String message) {
            super(message);
        }
    }
    // Nested class + unchecked exception
    // - возникают уже после компиляции, чаще из-за ошибок программиска

    static class EmptyPoliceField extends Exception {
        public EmptyPoliceField(String message) {
            super(message);
        }
    }
    // Nested class + checked exception
    // - не дает скоппилировать код, если ошибка обнаружена
    // Класс исключения обособлен от текущего состояние экземпляра
    // класса - носителя, не имеет доступа к его [экземпляра] нестатическим атрибутам
    // Экземпляр ожет быть создан сам по себе, отдельно от класса родителя.

    public static void main(String[] args) {

        // Local [inner] class
        // Класс хранит в себе текущее состояние экземпляра
        // класса - носителя и имеет доступ к его [экземпляра] атрибутам
        class CheckFields {
            public static void checkDwarfs(Dwarfs dwarf) throws EmptyDwarfField {
                if (dwarf.getCondition() == null ||
                        dwarf.getPlace() == null ||
                        dwarf.getPerson() == null ||
                        dwarf.getStuff() == null)
                    throw new EmptyDwarfField("There is [are] null[s] in your dwarf!");
            }
            public static void checkPolice(Police police) throws EmptyPoliceField {
                if (police.getCondition() == null ||
                        police.getPlace() == null ||
                        police.getStuff() == null)
                    throw new EmptyPoliceField("There is [are] null[s] in your police!");
            }
        }

        // Anonymous class
        ChangeScene change = new ChangeScene() {
            public void changeDwarfsScene(Persons person,
                                          Place place,
                                          Condition condition,
                                          Stuff stuff) {
                try {
                    CheckFields.checkDwarfs(new Dwarfs(person, place, condition, stuff));
                    dwarfs.setPerson(person);
                    dwarfs.setCondition(condition);
                    dwarfs.setPlace(place);
                    dwarfs.setStuff(stuff);
                }
                catch (EmptyDwarfField exception) {
                    System.out.println("-------------------------");
                    System.out.println(exception.getMessage() + " try again!");
                    System.out.println("-------------------------");
                }
            }

            public void changePoliceScene(Place place,
                                          Condition condition,
                                          Stuff stuff) {
                try {
                    CheckFields.checkPolice(new Police(place, condition, stuff));
                    police.setCondition(condition);
                    police.setPlace(place);
                    police.setStuff(stuff);
                }
                catch (EmptyPoliceField exception) {
                    System.out.println("---------------------------");
                    System.out.println(exception.getMessage() + " try again!");
                    System.out.println("---------------------------");
                }
            }
        };

        System.out.println(dwarfs.getPerson().getTitle() + " " + dwarfs.say());
        System.out.println(dwarfs.getCondition().getTitle() +
                " " + dwarfs.getPlace().getTitle() +
                " " + dwarfs.heard() +
                " " + dwarfs.getStuff().getTitle());

        change.changeDwarfsScene(Persons.Korotishki,
                Place.Back,
                Condition.Running,
                dwarfs.getStuff());

        System.out.println(dwarfs.getPerson().getTitle() +
                " " + dwarfs.around() +
                ", " + dwarfs.saw2() +
                " " + Persons.Kolosok.getTitle() +
                ", он " + dwarfs.getCondition().getTitle() +
                " " + dwarfs.comeBack() +
                " " + dwarfs.getPlace().getTitle());

        System.out.println(police.getCondition().getTitle() +
                " " + police.getPlace().getTitle() +
                " " + police.out() +
                " " + police.getPerson().getTitle());

        change.changePoliceScene(null, null, null);
        change.changePoliceScene(Place.Down,
                Condition.Quickly,
                Stuff.Guns);

        System.out.println(police.getCondition().getTitle() +
                " " + police.down() +
                ", " + police.stopped() +
                ", " + police.applied() +
                " " + police.getStuff().getTitle() +
                ", " + police.ready());

        change.changeDwarfsScene(null, null, dwarfs.getCondition(), null);
        change.changeDwarfsScene(Persons.Znayka,
                dwarfs.getPlace(),
                Condition.Hesitate,
                Stuff.Device);

        System.out.println(dwarfs.getPerson().getTitle() +
                " " + dwarfs.saw1() +
                " это, " + dwarfs.getCondition().getTitle() +
                " " + dwarfs.enabled() +
                " " + dwarfs.getStuff().getTitle());
        System.out.println(dwarfs.rangOut());

        change.changePoliceScene(Place.Back,
                Condition.NotSuspected,
                Stuff.ZeroGravity);

        System.out.println(police.getCondition().getTitle() +
                ", что " + police.couldBe() +
                " " + police.getStuff().getTitle() +
                ", " + police.getPerson().getTitle() +
                " " + police.shot());

        change.changePoliceScene(police.getPlace(),
                Condition.Speed,
                Stuff.Power);

        System.out.println(police.getStuff().getTitle() +
                " понесла их " + police.getPlace().getTitle() +
                " " + police.getCondition().getTitle());

        change.changePoliceScene(Place.InAir,
                Condition.TheSameTime,
                Stuff.Dot);

        System.out.println(police.getPerson().getTitle() +
                " " + police.rushed() +
                " " + police.getPlace().getTitle() +
                " и " + police.turnedInto() +
                " " + police.getStuff().getTitle());
    }

    //                              ОБРАЗЕЦ ИЗ ТЕКСТА ЗАДАНИЯ

    //    Пилюлькин сказал: Неожиданно в стороне послышались выстрелы.
    //    Коротышки обернулись и увидели Колоска, который бегом возвращался назад.
    //    В тот же миг из-за холма выскочили пятеро полицейских. Быстро спустившись вниз,
    //    они остановились, как по команде, и приложились к ружьям, готовясь выстрелить.
    //    Знайка увидел это и, ни секунды не медля, включил прибор невесомости.
    //    Раздался залп. Не подозревая, что могут оказаться в состоянии невесомости,
    //    полицейские выстрелили, и возникшая реактивная сила понесла их назад.
    //    В результате они [полицейские] помчались по воздуху с такой страшной скоростью,
    //    что в одну секунду превратились в едва заметные точки и скрылись за горизонтом

}
