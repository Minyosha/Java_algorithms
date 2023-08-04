package HW_4;

import HW_4.HashMap.Entity;

public class Program {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(4);


        String v = hashMap.put("+79005551122", "Александр");
        v = hashMap.put("+79005551123", "Сергей");
        v = hashMap.put("+79005551123", "Алексей");
        v = hashMap.put("+79005551124", "Александр1");
        v = hashMap.put("+79005551125", "Александр2");
        v = hashMap.put("+79005551126", "Александр3");
        v = hashMap.put("+79005551127", "Александр4");
        v = hashMap.put("+79005551128", "Александр5");


        String findValue1 = hashMap.get("+79005551122346457831");
        String findValue2 = hashMap.get("+79005551124");
        System.out.println(findValue1);
        System.out.println(findValue2);

        System.out.println();
        System.out.println("Изначальные данные:");
        for (Entity entity : hashMap) {
            System.out.println(entity.key + " : " + entity.value);
        }
        hashMap.displayAllElements();

        v = hashMap.remove("+79005551126");
        v = hashMap.remove("+79005551127");

        System.out.println();
        System.out.println("После удаления:");
        for (Entity entity : hashMap) {
            System.out.println(entity.key + " : " + entity.value);
        }
        hashMap.displayAllElements();

    }
}