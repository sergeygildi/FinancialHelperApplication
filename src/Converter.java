public class Converter {
    private final double usdRate;
    private final double eurRate;

    public Converter(double usd, double eur) {
        usdRate = usd;
        eurRate = eur;
    }

    public void convert(double uah) {
        System.out.println("Your savings in dollars: " + uah / usdRate);
        System.out.println("Your savings in euros: " + uah / eurRate);
    }

}