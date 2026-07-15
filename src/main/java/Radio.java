public class Radio {
    private int currentStation;
    private int volume;
    private int stationCount; // Количество радиостанций

    // Конструктор, принимающий желаемое количество радиостанций
    public Radio(int stationCount) {
        this.stationCount = stationCount;
        this.currentStation = 0;
        this.volume = 0;
    }

    // Конструктор без параметров — устанавливает количество радиостанций в 10 штук
    public Radio() {
        this.stationCount = 10; // Вызывает другой конструктор с параметром 10
    }

    // Геттер и сеттер для номера радиостанции
    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationCount) {
            this.currentStation = station;
        }
    }

    // Геттер и сеттер для громкости звука
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        }
    }

    // Метод для переключения на следующую радиостанцию
    public void next() {
        int nextStation = getCurrentStation() + 1;
        if (nextStation >= stationCount) {
            setCurrentStation(0);
        } else {
            setCurrentStation(nextStation);
        }
    }

    // Метод для переключения на предыдущую радиостанцию
    public void prev() {
        int prevStation = getCurrentStation() - 1;
        if (prevStation < 0) {
            setCurrentStation(stationCount - 1);
        } else {
            setCurrentStation(prevStation);
        }
    }

    // Метод для увеличения громкости на единицу
    public void increaseVolume() {
        int currentVolume = getVolume();
        if (currentVolume < 100) {
            setVolume(currentVolume + 1);
        }
        // Если громкость уже 100, ничего не делаем
    }

    // Метод для уменьшения громкости на единицу
    public void decreaseVolume() {
        int currentVolume = getVolume();
        if (currentVolume > 0) {
            setVolume(currentVolume - 1);
        }
        // Если громкость уже 0, ничего не делаем
    }

    // Геттер для количества радиостанций
    public int getStationCount() {
        return stationCount;
    }
}
