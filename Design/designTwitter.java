class Twitter {
    public class Tweet {
        int tweetId, time;
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    int time;
    Map<Integer, List<Tweet>> userToTweet;
    Map<Integer, Set<Integer>> userToFollowers;
    public Twitter() {
        this.userToTweet = new HashMap<>();
        this.userToFollowers = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!this.userToTweet.containsKey(userId)) {
            this.userToTweet.put(userId, new ArrayList<>());
        }
        this.userToTweet.get(userId).add(new Tweet(tweetId, this.time));
        this.follow(userId, userId);
        this.time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!this.userToFollowers.containsKey(userId)) {
            return new ArrayList<>();
        }
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a, b) -> b.time - a.time);
       // System.out.println(this.userToFollowers.get(userId));
        for(int following : this.userToFollowers.get(userId)) {
          //  System.out.println(this.userToTweet.get(following));
            if(!this.userToFollowers.containsKey(following))
                continue;
            for(Tweet tweet: this.userToTweet.get(following)) {
                feed.add(tweet);
            }
        }

        int k  = 0;
        List<Integer> res = new ArrayList<>();
        while(!feed.isEmpty() && k++ < 10) {
            res.add(feed.poll().tweetId);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!this.userToFollowers.containsKey(followerId)) {
            this.userToFollowers.put(followerId, new HashSet<>());
        }
        this.userToFollowers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        this.userToFollowers.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */