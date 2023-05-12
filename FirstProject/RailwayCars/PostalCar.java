package FirstProject.RailwayCars;

import java.util.Arrays;

public class PostalCar extends RailwayCar {

    private int id;
    private static int nextId = 1;
    private int mailSlots;
    private int maxSlots;
    private String[] mails;

    public PostalCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight,
                     int numOfSeats, String productionDate, String condition, int mailSlots, int maxSlots, String[] mails) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition);
        this.id = nextId;
        nextId++;
        this.mailSlots = mailSlots;
        this.maxSlots = maxSlots;
        this.mails = mails;
    }

    public int getMailSlots() {
        return mailSlots;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public String[] getMails() {
        return mails;
    }

    public void setMailSlots(int mailSlots) {
        this.mailSlots = mailSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public void setMails(String[] mails) {
        this.mails = mails;
    }

    public void sortMail() {
        Arrays.sort(mails, 0, mailSlots);
    }

    @Override
    public boolean isElectricityOn() {
        return false;
    }

    @Override
    public void load() {
        for (int i = 0; i < mailSlots; i++) {
            String sender = PostalCarGenerator.getRandomName();
            String text = PostalCarGenerator.getRandomTexts();
            String receiver = PostalCarGenerator.getRandomName();
            String city = PostalCarGenerator.getRandomCity();
            String mail = sender + " from " + city + " wrote to " + receiver + ": " + text;
            mails[i] = mail;
        }
    }


    @Override
    public void unload() {
        unload();
    }


    public void unload(String mail) {
        for (int i = 0; i < mailSlots; i++) {
            if (mails[i].equals(mail)) {
                mails[i] = null;
                System.out.println("Mail " + mail + " has been unloaded.");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Passenger car #" + id +
                ":\n  Shipper: " + getShipper() +
                "\n  Safety information available: " + isSafetyInfo() +
                "\n  Net weight: " + getNetWeight() + " kg" +
                "\n  Gross weight: " + getGrossWeight() + " kg" +
                "\n  Number of seats: " + getNumOfSeats() +
                "\n  Production date: " + getProductionDate() +
                "\n  Condition: " + getCondition() +
                "\n  Mails in the car: " + mailSlots + "\n" + getPostalList();
    }

    public String getPostalList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mailSlots; i++) {
            sb.append(i+1 + " letter: ").append(mails[i]).append("\n");
        }
        return sb.toString();
    }

}


