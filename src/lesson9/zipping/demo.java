package lesson9.zipping;

public class demo {

    public static void main(String[] args) {
        switch (args[0]){
            case "zip":
                Zip zip = new Zip(args[1]);
                break;
            case "unzip":
                UnZip unZip = new UnZip(args[1]);
                break;
            default:
                System.out.println("Please enter "+"zip"+" if you want intup to zip or "+
                        "unzip"+" if you want out[ut from zip");
        }

    }
}
