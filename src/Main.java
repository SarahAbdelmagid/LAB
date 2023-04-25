public class Main {
    public static void main(String[] args) {
        String insectPattern = """
                (|    _                                               |    _
                 ###O                                                 ###O
                |                                                    |
                   \s


                \t\t
                 |    _
                                  ###O
                                 |\s


                                 |    _
                                  ###O
                                 |)""";
        String landFile = """
                (|    _
                 ###O
                |)
                """;

        int insectCount = matchInsectPattern(insectPattern, landFile);
        System.out.println("Number of insects: " + insectCount);
    }

    private static int matchInsectPattern(String insectPattern, String landFile) {
        int count = 0;
        String[] insectLines = insectPattern.split("\n");
        String[] landLines = landFile.split("\n");

        for (int i = 0; i <= landLines.length - insectLines.length; i++) {
            for (int j = 0; j <= landLines[i].length() - insectLines[0].length(); j++) {
                if (isMatch(i, j, insectLines, landLines)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isMatch(int i, int j, String[] insectLines, String[] landLines) {
        for (int k = 0; k < insectLines.length; k++) {
            for (int l = 0; l < insectLines[k].length(); l++) {
                if (insectLines[k].charAt(l) != landLines[i + k].charAt(j + l)) {
                    return false;
                }
            }
        }

        return true;
    }
}
