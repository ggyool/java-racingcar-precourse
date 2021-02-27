package racingcar.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerChecker {
    public static Cars run(Cars cars) {
        int maxPosition = getMaxPosition(cars);
        List<Car> winners = getCarsInMaxPosition(cars, maxPosition);

        return new Cars(winners);
    }

//    private static int getMaxPosition(Cars cars) {
//        final Comparator<Car> comparator = Comparator.comparingInt(Car::getPosition);
//
//        return cars.getCars()
//                .stream()
//                .max(comparator)
//                .get()
//                .getPosition();
//    }

    private static int getMaxPosition(Cars cars) {
        final int ZERO = 0;

        return cars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(ZERO);
    }

    private static List<Car> getCarsInMaxPosition(Cars cars, int maxPosition) {
        return cars.getCars()
                .stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .collect(Collectors.toList());
    }
}


class Reward {
    int winningMoney;

    public Reward(final int i) {
        winningMoney = i;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}