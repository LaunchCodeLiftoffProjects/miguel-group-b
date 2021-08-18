package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class RestaurantData extends AbstractEntity {

//
//     * Returns the results of searching the Jobs data by field and search term.
//     *
//             * For example, searching for employer "Enterprise" will include results
//     * with "Enterprise Holdings, Inc".
//            *
//            * @param column Job field that should be searched.
//     * @param value Value of the field to search for.
//            * @param allJobs The list of jobs to search.
//     * @return List of all jobs matching the criteria.
//     */
    public static ArrayList<Restaurant> findByColumnAndValue(String column, String value, Iterable<Restaurant> allRestaurants) {

        ArrayList<Restaurant> results = new ArrayList<>();


        if (value.toLowerCase().equals("all")){
            return (ArrayList<Restaurant>) allRestaurants;
        }

        if (column.equals("all")){
            results = findByValue(value, allRestaurants);
            return results;
        }
        for (Restaurant restaurant : allRestaurants) {

            String aValue = getFieldValue(restaurant, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(restaurant);
            }
        }

        return results;
    }

    public static String getFieldValue(Restaurant restaurant, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = restaurant.getName();
        } else if (fieldName.equals("TypeOfRestaurant")) {
            theValue = restaurant.getTypeOfRestaurant().toString();
        }  else if (fieldName.equals("LocationOfRestaurant")){
            theValue = restaurant.getLocationOfRestaurant().toString();
        } else {
            theValue = restaurant.getRating().toString();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allRestaurants The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Restaurant> findByValue(String value, Iterable<Restaurant> allRestaurants) {
        String lower_val = value.toLowerCase();

        ArrayList<Restaurant> results = new ArrayList<>();

        for (Restaurant restaurant : allRestaurants) {

            if (restaurant.getName().toLowerCase().contains(lower_val)) {
                results.add(restaurant);
            } else if (restaurant.getTypeOfRestaurant().toString().toLowerCase().contains(lower_val)) {
                results.add(restaurant);
            } else if (restaurant.getLocationOfRestaurant().toString().toLowerCase().contains(lower_val)) {
                results.add(restaurant);
            }  else if (restaurant.getRating().toString().toLowerCase().contains(lower_val)) {
                    results.add(restaurant);

            } else if (restaurant.toString().toLowerCase().contains(lower_val)) {
                results.add(restaurant);
            }

        }

        return results;
    }


}



