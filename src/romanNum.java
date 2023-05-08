public enum romanNum { // Перечесление значений римских цифр с их арабским эквивалентом
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10);

    private final int value;

    romanNum(int value) {
        this.value = value;
    }

    public int getValue() {
        return (this.value); // Возврат к значению в арабской системе
    }
}
