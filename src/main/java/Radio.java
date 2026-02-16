public class Radio {
    private int currentStation;
    private int volume;

    // Геттер и сеттер для номера радиостанции
    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station <= 9) {
            this.currentStation = station; //Ключевое слово this помогает обращаться к полю данного класса
        }
    }

    // Геттер и сеттер для громкости звука
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume; //Ключевое слово this помогает обращаться к полю данного класса
        }
    }

    // Метод для переключения на следующую радиостанцию
    public void next() {
        int nextStation = getCurrentStation() + 1; //берем значение нынешнего номера и делаем +1 к нему
        if (nextStation > 9) {
            setCurrentStation(0); //Если уже включена 9-ая станция, включаем нулевую
        } else {
            setCurrentStation(nextStation);
        }
    }

    // Метод для переключения на предыдущую радиостанцию
    public void prev() {
        int prevStation = getCurrentStation() - 1;
        if (prevStation < 0) {
            setCurrentStation(9); //Если уже включена 0-ая станция, включаем девятую
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
}
