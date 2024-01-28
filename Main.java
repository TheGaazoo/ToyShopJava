import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String[] ids = {"1", "2", "3"};
        String[] names = {"Зеленый слоник", "Хороший парень (Chucky)", "Кукла (Эбигейл)"};
        int[] frequencies = {2, 3, 7};
        PriorityQueue<String> toyQueue = new PriorityQueue<>((t1, t2) -> {
            int frequency1 = frequencies[Integer.parseInt(t1) - 1];
            int frequency2 = frequencies[Integer.parseInt(t2) - 1];
            return frequency2 - frequency1;
        });

        for (String id : ids) {
            toyQueue.add(id);
        }

        System.out.println("Игрушки в порядке убывания частоты:");
        while (!toyQueue.isEmpty()) {
            String id = toyQueue.poll();
            int index = Integer.parseInt(id) - 1;
            System.out.println("ID: " + id + ", Название: " + names[index] + ", Частота: " + frequencies[index]);
        }

        String winnerId = Get(frequencies);
        int winnerIndex = Integer.parseInt(winnerId) - 1;
        System.out.println("Победитель лотереи: ID: " + winnerId + ", Название: " + names[winnerIndex] + ", Частота: " + frequencies[winnerIndex]);
        try { 
            FileWriter fileWriter = new FileWriter("result.txt");
            for (int i = 0; i < 10; i++) {
                String result = Get(frequencies);
                int index = Integer.parseInt(result) - 1;
                String line = "ID: " + result + ", Название: " + names[index] + ", Частота: " + frequencies[index];
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
            System.out.println("Результаты записаны в файл result.txt");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл.");
            e.printStackTrace();
        }
    }

    private static String Get(int[] frequencies) {
        int random = (int) (Math.random() * 10);
        if (random < 2) {
            return "1";
        } else if (random < 4) {
            return "2";
        } else {
            return "3";
        }
    }
}