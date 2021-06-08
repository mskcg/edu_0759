public class Hotel {
    private Room[] rooms;

    public Hotel(Room[] rooms) { this.rooms = rooms; }

    public void showRooms() {
        String RoomList = "";
        for (int i = 0; i < rooms.length; i++) {
            RoomList += rooms[i].getRoomNumber()+" ";
        }
        System.out.println("Номера всех комнат в отеле: "+RoomList);
    }

    public void showFreeRooms(){
        String freeRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isFree()) freeRoomsList += rooms[i].getRoomNumber()+" ";
        }
        System.out.println("Номера свободных комнат: "+freeRoomsList);
    }

    public void showRoomsWC(){
        String RoomsWCList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWc()) RoomsWCList += rooms[i].getRoomNumber()+" ";
        }
        System.out.println("Номера комнат c сан.узлом: "+RoomsWCList);
    }

    public void showRoomsEat(){
        String RoomsEatList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isEat()) RoomsEatList += rooms[i].getRoomNumber()+" ";
        }
        System.out.println("Номера комнат c питанием: "+RoomsEatList);
    }

    public void showRoomsWF(){
        String RoomsWFList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isEat()) RoomsWFList += rooms[i].getRoomNumber()+" ";
        }
        System.out.println("Номера комнат c WiFi: "+RoomsWFList);
    }

    public void reserveRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && room.isFree()){
                room.setFree(false);
                info = ("Комната номер "+roomNumber+" успешно забронированна");
                break;
            }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
                info = "Комната "+roomNumber+" занята";
                break;
            }
        }
        System.out.println(info);
    }

    public void releaseRoom(byte roomNumber) {
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && !room.isFree()){
                room.setFree(true);
                info = ("Комната номер "+roomNumber+" успешно освобождена");
                break;
            }else if(room.getRoomNumber() == roomNumber && room.isFree()){
                info = "Комната "+roomNumber+" уже свободна";
                break;
            }
        }
    }

    public void showRoom(byte roomNumber) {
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber){
                info = ("Комната номер "+roomNumber);
                if (room.isFree()) {info += " свободна";}
                else {info += " занята";}
                info += ". В ней количество мест: "+room.getBeds();
                if(room.isWifi()) {info += "; есть WiFi";}
                if(room.isEat()) {info += "; есть питание";}
                if(room.isWc()) {info += "; есть сан.узел";}
                System.out.println(info);
                return;
            }
        }
        System.out.println(info);
    }

    public void ShowBedsRooms(byte beds) {
        if (beds>3 || beds<1) {
            System.out.println("Неверный ввод. Доступные варианты: 1,2,3");
            return;
        }
        String RoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getBeds() == beds) RoomsList += rooms[i].getRoomNumber()+" ";
        }
        System.out.println("Номера комнат c количеством кроватей "+beds + ": "+RoomsList);
    }
}