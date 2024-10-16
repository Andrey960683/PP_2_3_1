package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CarDaoImpl implements CarDao{

    private final List<Car> carList;

    public CarDaoImpl() {
        this.carList = new ArrayList<>(List.of(new Car("Model1",1,2010),
                new Car("Model2",2,2011),
                new Car("Model3",3,2012),
                new Car("Model4",4,2013),
                new Car("Model5",5,2014)));
    }

    @Override
    public List<Car> getListCars(Integer count) {
        count = (count == null || count > 5) ? 5 : count < 0 ? 0 : count;
        return carList.stream().limit(count).toList();
    }
}
