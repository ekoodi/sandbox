package fi.saimia.ekoodi.sandbox.layer.service.mdl;

public enum Severity {
	
	INFO(6), ERROR(3);
	
    private final int value;

    private Severity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }	

}
