class Lottery {
    private static int[] frequencies;

    Lottery(int[] frequencies) {
        Lottery.frequencies = frequencies;
    }

    public Lottery(Toy[] toys) {
       
    }

    String getWinnerId() {
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