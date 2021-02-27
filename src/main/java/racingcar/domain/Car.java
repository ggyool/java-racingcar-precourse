package racingcar.domain;

import racingcar.validator.CarNameValidator;

public class Car {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final String name;
    private int position = ZERO;

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
    }

    public void moveForwardOneStep() {
        moveForward(ONE);
    }

    public void moveForward(int step) {
        if (step <= ZERO) {
            return;
        }
        position += step;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
