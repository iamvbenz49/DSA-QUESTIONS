class FoodRatings {
    Map<String,PriorityQueue<Food>> foodRating = new HashMap<>(); // cuisine --> rating, food
    Map<String,Food> menu = new HashMap<>(); // food --> cuisine
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0;i<cuisines.length;i++){
            if(!foodRating.containsKey(cuisines[i])){
                PriorityQueue<Food> pq = new PriorityQueue<>((x,y)->x.rating==y.rating?x.food.compareTo(y.food):y.rating-x.rating);
                foodRating.put(cuisines[i],pq);
            }
            Food food = new Food(foods[i], cuisines[i],ratings[i]);
            PriorityQueue<Food> pq = foodRating.get(cuisines[i]);
            pq.add(food);
            menu.put(foods[i],food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food currentFood = menu.get(food);
        PriorityQueue<Food> pq = foodRating.get(currentFood.cuisine);
        pq.remove(currentFood);
        currentFood.rating = newRating;
        pq.add(currentFood);
    }
    
    public String highestRated(String cuisine) {
        return foodRating.get(cuisine).peek().food;
    }
}
class Food{
    String food;
    String cuisine;
    int rating;
    public Food(String food, String cuisine, int rating){
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}
