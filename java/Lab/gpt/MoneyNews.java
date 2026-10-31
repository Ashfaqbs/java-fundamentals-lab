package ChatGpt;

public class MoneyNews {

//    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        // Fetch the RSS feed from Google News
//        URL url = new URL("https://news.google.com/rss/search?q=money%20OR%20gold%20OR%20stock%20market&hl=en-US&gl=US&ceid=US:en");
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.parse(url.openStream());
//
//        // Parse the RSS feed and extract the top 5 articles
//        List<Article> articles = new ArrayList<>();
//        NodeList items = doc.getElementsByTagName("item");
//        for (int i = 0; i < items.getLength(); i++) {
//            Element item = (Element) items.item(i);
//            String title = item.getElementsByTagName("title").item(0).getTextContent();
//            String link = item.getElementsByTagName("link").item(0).getTextContent();
//            articles.add(new Article(title, link));
//            if (articles.size() == 5) {
//                break;
//            }
//        }
//
//        // Print the top 5 articles
//        System.out.println("Top 5 Trending Articles on Money News:");
//        for (int i = 0; i < articles.size(); i++) {
//            System.out.println((i + 1) + ". " + articles.get(i).getTitle());
//            System.out.println("   " + articles.get(i).getLink());
//        }
//    }

    private static class Article {
        private String title;
        private String link;

        public Article(String title, String link) {
            this.title = title;
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }
    }
}
