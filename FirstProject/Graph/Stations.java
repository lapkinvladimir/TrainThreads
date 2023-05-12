package FirstProject.Graph;


import java.util.Random;

public class Stations {

    private String[] Stations = {
            "Lop Buri",
            "Kowalewo Pomorskie Miasto",
            "Ostrowite k. Golubia",
            "Golub-Dobrzyn",
            "Chelmoniec",
            "Nieporet",
            "Gdynia Glowna",
            "Jurkowo Wegorzewskie",
            "Korzybie",
            "Lankiejmy",
            "Jonkowo",
            "Tolniki Wielkie",
            "Rajec Poduchowny",
            "Gamerki Wielkie",
            "Kyiv",
            "Lviv",
            "Przemysl",
            "Kosice",
            "Ternopil",
            "Zakopane",
            "Uzhhorod",
            "Koszalin",
            "Bardejov",
            "Mukachevo",
            "Kosice Predmestie",
            "Nowy Sacz",
            "Presov",
            "Lublin",
            "Chernivtsi",
            "Zamosc",
            "Kosice - Moldavska cesta",
            "Bohumin",
            "Babiarova",
            "Zilina",
            "Rzeszow",
            "Piestany",
            "Zakopane Polana",
            "Stryi",
            "Zakopane Budzowski N.",
            "Prague",
            "Humenne",
            "Ostrava",
            "Kosice - Lomnicka",
            "Nowy Targ",
            "Pardubice",
            "Kosice – Barca",
            "Mielec",
            "Poprad-Tatry",
            "Kosice - Stanicne",
            "Kielce",
            "Zakopane Suche",
            "Zvolen",
            "Kosice - Zapad",
            "Kosice - Juzna trieda",
            "Poprad-Tatry zastavka",
            "Trnava",
            "Zakopane Harenda",
            "Kosice - Saca",
            "Stara Lubovna",
            "Lodz",
            "Dnipro",
            "Skalite",
            "Zakopane Polana Szymoszkowa",
            "Wroclaw",
            "Kosice - Moldavska",
            "Kosice - KVP",
            "Prerov",
            "Zakopane Kościelisko",
            "Kosice - Vyhliadka",
            "Poprad zastavka",
            "Bratislava",
            "Kosice - Park Komenského",
            "Kosice - Stanicna",
            "Ostrava-Svinov",
            "Zakopane",
            "Przemysl Glowny",
            "Kosice-Juh",
            "Ternopol",
            "Zakopane Gubalowka",
            "Uzhgorod-Pas.",
            "Szczecin Glowny",
            "Bardejovska-NV",
            "Mukachevo-Pas.",
            "Kosice-Mlynska",
            "Nowy Sacz Glowny",
            "Presov-Sever",
            "Lublin-Polnoc",
            "Chernivtsi-Pas.",
            "Zamosc-Poludnie",
            "Kosice-Stanicne Nam.",
            "Bohumín-Podrazi",
            "Babiarova-Odbocka",
            "Zilina-Zavodie",
            "Rzeszow Glowny",
            "Piestany Lazne",
            "Zakopane Pardalowka",
            "Stryi-Pas.",
            "Zakopane Budzowski W.",
            "Prague-Masarykovo n.",
            "Humenne-Zelez. st."
    };


    public void addStations(TrainStationGraph graph) {
        for (String station : Stations) {
            graph.addStation(station);
        }
    }


    public void addLines(TrainStationGraph graph) {
        int numStations = Stations.length;
        for (int i = 0; i < numStations - 1; i++) {
            String source = Stations[i];
            String destination = Stations[i + 1];
            int distance = new Random().nextInt(501) + 100;
            graph.addLine(source, destination, distance);
        }
        String source = Stations[numStations - 1];
        String destination = Stations[0];
        int distance = new Random().nextInt(501) + 100;
        graph.addLine(source, destination, distance);
        for (int i = 0; i <=30; i++){
            Random random = new Random();
            int index1 = random.nextInt(100);
            int index2 = random.nextInt(100);
            if (index1 == index2){
                index2 = random.nextInt(100);
            }
            String source1 = Stations[index1];
            String destination1 = Stations[index2];
            int distance1 = new Random().nextInt(501) + 100;
            graph.addLine(source1, destination1, distance1);
        }
    }


}
