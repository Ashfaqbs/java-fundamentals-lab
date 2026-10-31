package ChatGpt;

public class TwitterTrending {
//
//    public static void main(String[] args) throws TwitterException {
//        // Set up the Twitter API client
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true)
//          .setOAuthConsumerKey("your_consumer_key")
//          .setOAuthConsumerSecret("your_consumer_secret")
//          .setOAuthAccessToken("your_access_token")
//          .setOAuthAccessTokenSecret("your_access_token_secret");
//        TwitterFactory tf = new TwitterFactory(cb.build());
//        Twitter twitter = tf.getInstance();
//
//        // Get the top 5 trending topics
//        Trends trends = twitter.getPlaceTrends(1);
//        String[] trendNames = new String[5];
//        for (int i = 0; i < 5; i++) {
//            trendNames[i] = trends.getTrends()[i].getName();
//        }
//
//        // Search for the top tweets for each trending topic
//        List<Tweet> tweets = new ArrayList<>();
//        for (String trendName : trendNames) {
//            tweets.addAll(searchTweets(twitter, trendName, 5));
//        }
//
//        // Print the top tweets for each trending topic
//        System.out.println("Top 5 Trending Topics and Their Top Tweets on Twitter:");
//        for (int i = 0; i < trendNames.length; i++) {
//            System.out.println((i + 1) + ". " + trendNames[i]);
//            List<Tweet> trendTweets = new ArrayList<>();
//            for (Tweet tweet : tweets) {
//                if (tweet.getText().contains(trendNames[i])) {
//                    trendTweets.add(tweet);
//                    if (trendTweets.size() == 3) {
//                        break;
//                    }
//                }
//            }
//            for (int j = 0; j < trendTweets.size(); j++) {
//                Tweet tweet = trendTweets.get(j);
//                System.out.println("   " + (j + 1) + ". " + tweet.getScreenName() + ": " + tweet.getText());
//            }
//        }
//    }
//
//    private static List<Tweet> searchTweets(Twitter twitter, String query, int count) throws TwitterException {
//        List<Tweet> tweets = new ArrayList<>();
//        for (twitter4j.Status status : twitter.search(query).getTweets()) {
//            tweets.add(new Tweet(status.getUser().getScreenName(), status.getText()));
//            if (tweets.size() == count) {
//                break;
//            }
//        }
//        return tweets;
//    }
//
//    private static class Tweet {
//        private String screenName;
//        private String text;
//
//        public Tweet(String screenName, String text) {
//            this.screenName = screenName;
//            this.text = text;
//        }
//
//        public String getScreenName() {
//            return screenName;
//        }
//
//        public String getText() {
//            return text;
//        }
//    }
}
