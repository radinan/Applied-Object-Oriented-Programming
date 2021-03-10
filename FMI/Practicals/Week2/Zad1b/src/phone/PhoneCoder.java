package phone;

public class PhoneCoder {
    private int key;

    public PhoneCoder(int key) {
        setKey(key);
    }

    public PhoneCoder() {
        setKey(1);
    }

    public double getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key >= 1 && key <=9 ? key : 1;
    }

    public String encode (String phoneNumber) {
        if(phoneNumber != null && phoneNumber.length() == 4) {
            int originalNumber = Integer.parseInt(phoneNumber);
            int firstDigit, secondDigit, thirdDigit, fourthDigit;

            fourthDigit = originalNumber % 10;
            originalNumber /= 10;

            thirdDigit = originalNumber % 10;
            originalNumber /= 10;

            secondDigit = originalNumber % 10;
            originalNumber /= 10;

            firstDigit = originalNumber % 10;

            firstDigit = (firstDigit + key) % 10;
            secondDigit = (secondDigit + key) % 10;
            thirdDigit = (thirdDigit + key) % 10;
            fourthDigit = (fourthDigit + key) % 10;

            return String.format("%s%s%s%s", thirdDigit, fourthDigit, firstDigit, secondDigit);
        } else {
            return "Invalid";
        }
    }

    public String decode (String codedPhoneNumber) {
        if(codedPhoneNumber != null && codedPhoneNumber != "Invalid" && codedPhoneNumber.length() == 4) {
            int originalNumber = Integer.parseInt(codedPhoneNumber);
            int firstDigit, secondDigit, thirdDigit, fourthDigit;

            fourthDigit = originalNumber % 10;
            originalNumber /= 10;

            thirdDigit = originalNumber % 10;
            originalNumber /= 10;

            secondDigit = originalNumber % 10;
            originalNumber /= 10;

            firstDigit = originalNumber % 10;

            firstDigit = (firstDigit + (10 - key)) % 10;
            secondDigit = (secondDigit + (10 - key)) % 10;
            thirdDigit = (thirdDigit + (10 - key)) % 10;
            fourthDigit = (fourthDigit + (10 - key)) % 10;

            return String.format("%d%d%d%d", thirdDigit, fourthDigit, firstDigit, secondDigit);
        } else {
            return "Invalid";
        }
    }

    @Override
    public String toString() {
        return String.format("PhoneCoder : %d", key);
    }
}
