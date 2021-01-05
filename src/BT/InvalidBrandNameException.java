package BT;

public class InvalidBrandNameException extends Exception {
    private String invalidBrand;

    public InvalidBrandNameException() {
    }

    public InvalidBrandNameException(String invalidBrand) {
        this.invalidBrand = invalidBrand;
    }

    @Override
    public String getMessage() {
        return invalidBrand;
    }
}
