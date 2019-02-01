package com.example.demo.dbinit;


import com.example.demo.model.Restaurants;
import com.example.demo.model.Reviews;
import com.example.demo.model.Users;
import com.example.demo.repositories.RestaurantsRepository;
import com.example.demo.repositories.ReviewsRepository;
import com.example.demo.repositories.UsersRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private RestaurantsRepository restaurantsRepository;
    private ReviewsRepository reviewsRepository;
    private UsersRepository usersRepository;

    public DataLoader(RestaurantsRepository restaurantsRepository, ReviewsRepository reviewsRepository, UsersRepository usersRepository) {
        this.restaurantsRepository = restaurantsRepository;
        this.reviewsRepository = reviewsRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init(){
        Users michaelScofield = new Users("Michael", "scofield@panama.com", "trudnehaselko", "scofield.jpg");
        Users zdzislawNowak = new Users("Zdzisław", "zdziszek@wp.pl", "trudnehaselko", "nowak.jpg");
        Users barneyStinson = new Users ("Barney", "stinson@gnb.com", "awesome", "barney.jpg");
        Users lilyAldrin = new Users ("Lily", "lily@kindergarden.com", "marshall", "lily.jpg");
        Users marshallEriksen = new Users ("Marshall", "marshall@ecology.com", "lily123", "marshall.jpg");
        Users tedMosby = new Users ("Ted", "mosby@gnb.com", "architecture62", "mosby.jpg");

        usersRepository.save(michaelScofield);
        usersRepository.save(zdzislawNowak);
        usersRepository.save(barneyStinson);
        usersRepository.save(lilyAldrin);
        usersRepository.save(marshallEriksen);
        usersRepository.save(tedMosby);

        Restaurants darmozjad = new Restaurants("Darmozjad", "Jastrzębie-Zdrój", "Restauracja położona w malowniczym krajobrazie dawnej stacji benzynowej.", "Foto");
        Restaurants zymft = new Restaurants("Zymft", "Żory", "Piękna restauracja", "Foto");
        Restaurants burgerbrothers = new Restaurants("Burger Brothers", "Cieszyn", "Restauracja zlokalizowana przy rynku.", "Foto");
        Restaurants burgerynoca = new Restaurants("Burgery Nocą", "Warszawa", "Burgerownia słynąca z szybkich dostaw.", "Foto");
        Restaurants wheelburger = new Restaurants ("Wheel Burger", "Żory", "Mała burgerownia ulokowana w centrum miasta.", "Foto");

        restaurantsRepository.save(burgerbrothers);
        restaurantsRepository.save(burgerynoca);
        restaurantsRepository.save(wheelburger);
        restaurantsRepository.save(zymft);
        restaurantsRepository.save(darmozjad);

        Reviews reviewZymft1 = new Reviews(1, 1, "Super restauracja.", 5);
        reviewsRepository.save(reviewZymft1);

        zymft.getReviews().add(reviewZymft1);
        reviewZymft1.getRestaurants().add(zymft);

        Reviews reviewDarmozjad1 = new Reviews(2, 2, "Burgery był pyszne!", 5);

        reviewsRepository.save(reviewDarmozjad1);

        darmozjad.getReviews().add(reviewDarmozjad1);
        reviewDarmozjad1.getRestaurants().add(darmozjad);

        Reviews reviewBurgerbrothers1 = new Reviews (2, 3, "Burger z serem był naprawdę świetny.", 5);
        Reviews reviewBurgerbrothers2 = new Reviews (5, 3, "Jedzenie bardzo dobre, ale piwo mi nie smakowało.", 4);
        Reviews reviewBurgerbrothers3 = new Reviews (4, 3, "Wszystko okej!", 5);

        reviewsRepository.save(reviewBurgerbrothers1);
        reviewsRepository.save(reviewBurgerbrothers2);
        reviewsRepository.save(reviewBurgerbrothers3);

        burgerbrothers.getReviews().add(reviewBurgerbrothers1);
        reviewBurgerbrothers1.getRestaurants().add(burgerbrothers);
        burgerbrothers.getReviews().add(reviewBurgerbrothers2);
        reviewBurgerbrothers2.getRestaurants().add(burgerbrothers);
        burgerbrothers.getReviews().add(reviewBurgerbrothers3);
        reviewBurgerbrothers3.getRestaurants().add(burgerbrothers);

        Reviews reviewBurgerynoca1 = new Reviews (3, 4, "Długi czas oczekiwania, jednak było warto.", 4 );
        Reviews reviewBurgerynoca2 = new Reviews (6, 4, "Niestety restauracja położona jest w złej lokalizacji.", 3);

        reviewsRepository.save(reviewBurgerynoca1);
        reviewsRepository.save(reviewBurgerynoca2);

        burgerynoca.getReviews().add(reviewBurgerynoca1);
        reviewBurgerynoca1.getRestaurants().add(burgerynoca);
        burgerynoca.getReviews().add(reviewBurgerynoca2);
        reviewBurgerynoca2.getRestaurants().add(burgerynoca);

        Reviews reviewWheelburger1 = new Reviews (1, 5, "Jedzenie było dobre, lecz lokal jest mały", 4);
        Reviews reviewWheelburger2 = new Reviews(3, 5, "Niestety, ale burger mi nie smakował.",1);

        reviewsRepository.save(reviewWheelburger1);
        reviewsRepository.save(reviewWheelburger2);

        wheelburger.getReviews().add(reviewWheelburger1);
        reviewWheelburger1.getRestaurants().add(wheelburger);
        wheelburger.getReviews().add(reviewWheelburger2);
        reviewWheelburger2.getRestaurants().add(wheelburger);




    }


}
