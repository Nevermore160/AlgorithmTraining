import java.util.*;

public class HelloWord {

    public static void main(String[] args) {
        System.out.println(Solution.isPerfectSquare(2147483647));
    }

    @SuppressWarnings("all") //压制警告
    static class Solution {
        public static List<Integer> preorderTraversal(TreeNode root) {
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            List<Integer> list = new LinkedList<>();
            if (root == null) return list;
            deque.add(root);
            while (!deque.isEmpty()){
                TreeNode node = deque.remove();
                list.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            return list;
        }

        public static List<Integer> preorderTraversal1(TreeNode root){
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> list = new LinkedList<>();
            if (root == null) return list;
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
            return list;
        }

        public static boolean isPerfectSquare(int num) {
            if (num == 1 || num == 0) return true;
            long n = num / 2, x = 0, y = num, k = 0;
            long m;
            while (x - y != -1 && x != y && x - y != 1){
                m = n * n * 1L;
                if (m < num) {
                    x = n;
                    n = (n + y) / 2;
                }
                if (m > num){
                    y = n;
                    n = (x + n) / 2;
                }
                if (n * n == num) return true;
            }
            return false;
        }

        public static boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            List<Integer> list = new ArrayList<>();
            while (head.next != null) {
                list.add(head.val);
                head = head.next;
            }
            list.add(head.val);
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).equals(list.get(list.size() - 1 - i))) return false;
            }
            return true;
        }

        public static List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> list = new LinkedList<>();
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    List<Integer> list1 = new LinkedList<>();
                    list1.add(i);
                    list1.add(j);
                    list.add(list1);
                }
            }
            return list;
        }

        public boolean repeatedSubstringPattern(String s) {
            return (s + s).indexOf(s, 1) != s.length();
        }

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int min_depth = Integer.MAX_VALUE;
            if (root.left != null) {
                min_depth = Math.min(minDepth(root.left), min_depth);
            }
            if (root.right != null) {
                min_depth = Math.min(minDepth(root.right), min_depth);
            }
            return min_depth + 1;
        }

        public static boolean isValid(String s) {
            if (s.length() == 0) return true;
            Stack<Character> stack = new Stack<>();
            Map<Character,Character> map = new HashMap<>();
            map.put('(',')');
            map.put('[',']');
            map.put('{','}');
            map.put(')','f');
            map.put(']','f');
            map.put('}','f');
            stack.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (!stack.isEmpty() && s.charAt(i) == map.get(stack.peek())) stack.pop();
                else stack.add(s.charAt(i));
            }
            if (stack.isEmpty()) return true;
            return false;
        }

        public void solve(char[][] board) {
            List<int[]> list = new ArrayList<>();
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O'){
                    int num[] = new int[2];
                    num[0] = i;
                    num[1] = 0;
                    list.add(num);
                }else if (board[i][n - 1] == 'O'){
                    int num[] = new int[2];
                    num[0] = i;
                    num[1] = n - 1;
                    list.add(num);
                }
            }
            for (int i = 0; i < n; i++) {
                if (board[0][i] == 'O'){
                    int num[] = new int[2];
                    num[0] = 0;
                    num[1] = i;
                    list.add(num);
                }else if (board[m - 1][i] == 'O'){
                    int num[] = new int[2];
                    num[0] = m -1;
                    num[1] = i;
                    list.add(num);
                }
            }
        }

        public static int countBinarySubstrings(String s) {
            if (s.length() == 0 || s.length() == 1) return 0;
            int sum = 0, temp = 1;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) != s.charAt(i + 1)){
                    list.add(temp);
                    temp = 1;
                }else {
                    temp ++;
                }
            }
            list.add(temp);
            for (int i = 0; i < list.size() - 1; i++) {
                sum += Math.min(list.get(i), list.get(i + 1));
            }
            return sum;
        }

        public void preOrderTraverse2(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null || !stack.empty()) {
                if (node != null) {
                    System.out.print(node.val + "->");
                    stack.push(node);
                    node = node.left;
                } else {
                    TreeNode tem = stack.pop();
                    node = tem.right;
                }
            }
        }

        public void postOrderTraverse(TreeNode root) {
            TreeNode cur, pre = null;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.empty()) {
                cur = stack.peek();
                if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                    System.out.print(cur.val + "->");
                    stack.pop();
                    pre = cur;
                } else {
                    if (cur.right != null)
                        stack.push(cur.right);
                    if (cur.left != null)
                        stack.push(cur.left);
                }
            }
        }

        public static void inOrderTraverse(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    TreeNode tem = stack.pop();
                    System.out.print(tem.val + "->");
                    node = tem.right;
                }
            }
        }

        public static boolean isSameTree(TreeNode p, TreeNode q) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            Queue<TreeNode> queue1 = new ArrayDeque<>();
            queue.offer(p);
            queue1.offer(q);
            TreeNode node, node1;
            while (queue != null || queue1 != null){
                node = queue.poll();
                node1 = queue1.poll();
                if ((node != null || node1 != null) && node.val != node1.val) return false;
                if (node != null && node.right != null) queue.offer(node.right);
                if (node != null && node.left != null) queue.offer(node.left);
                if (node1 != null && node1.right != null) queue1.offer(node1.right);
                if (node1 != null && node1.left != null) queue1.offer(node1.left);
            }
            return true;
        }


        public static List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> lists = new LinkedList<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (i == j) continue;
                    else if (Palindrome(words[i] + words[j])) {
                        List<Integer> list = new LinkedList<>();
                        list.add(i);
                        list.add(j);
                        lists.add(list);
                    } else continue;
                }
            }
            return lists;
        }

        public static boolean Palindrome(String s) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
            }
            return true;
        }

        public static int rob(TreeNode root) {
            int[] money = dfs(root);
            return Math.max(money[0], money[1]);
        }

        public static int[] dfs(TreeNode root) {
            if (root == null) return new int[]{0, 0};
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int select = root.val + left[1] + right[1];
            int notselect = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
            return new int[]{select, notselect};
        }

        public static boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer> list = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            while (true) {
                int a = list.size();
                for (int i = 0; i < prerequisites.length; i++) {
                    if (list.contains(prerequisites[i][1])) continue;
                    set.add(prerequisites[i][0]);
                    //System.out.println(set);
                    //System.out.println(list);
                }
                for (int i = 0; i < numCourses; i++) {
                    if (list.contains(i)) continue;
                    if (!set.contains(i)) list.add(i);
                    //System.out.println(list);
                }
                if (a == list.size()) break;
                if (list.size() >= numCourses) break;
                set.clear();
            }
            if (list.size() < numCourses) return false;
            return true;
        }

        public void flatten(TreeNode root) {
            if (root == null) return;
            Stack<TreeNode> deque = new Stack<>();
            List<TreeNode> list = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                TreeNode node = deque.pop();
                list.add(node);
                if (node.right != null) deque.add(node.right);
                if (node.left != null) deque.add(node.left);
            }
            for (int i = 1; i < list.size(); i++) {
                root.right = list.get(i);
                root.left = null;
                root = root.right;
            }
        }

        public int findMagicIndex(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == i) return i;
            }
            return -1;
        }

        public static int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                int Max = 0;
                for (int j = 1; j < i; j++) {
                    Max = Math.max(Max, Math.max(j * (i - j), j * dp[i - j]));
                }
                dp[i] = Max;
            }
            return dp[n];
        }

        public static int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;

        }

        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) return true;
            boolean[] booleans = new boolean[s.length()];
            int num = 0;
            for (int i = 0; i < t.length(); i++) {
                if (num < s.length() && t.charAt(i) == s.charAt(num)) {
                    booleans[num] = true;
                    num++;
                }
            }
            return booleans[s.length() - 1];
        }

        public static int number = 0;

        public static boolean divisorGame(int N) {
            if (N == 1) return false;
            while (N > 1) {
                int num = (int) Math.floor(Math.sqrt(N));
                for (int i = num; i > 0; i--) {
                    if (N % i == 0) N -= i;
                }
                number++;
            }
            if (number % 2 == 1) return true;
            else return false;
        }

        public static int lengthOfLongestSubstring(String s) {
            String substring1 = s.substring(1, s.length() - 1);
            char a[] = substring1.toCharArray();
            Arrays.sort(a);
            ArrayList<Character> b = new ArrayList<Character>();

            for (int i = 0; i < a.length; i++) {
                b.add(a[i]);
            }
            for (int j = b.size(); j > 1; j--) {
                if (b.get(j - 1) == b.get(j - 2)) {
                    b.remove(j - 1);
                }
            }
            char[] str = new char[b.size()];

            for (int k = 0; k < b.size(); k++) {
                str[k] = b.get(k);
            }

            return str.length;
        }

        public static int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int rows = matrix.length, columns = matrix[0].length;
            boolean[][] visited = new boolean[rows][columns];
            int total = rows * columns;
            int[] order = new int[total];
            int row = 0, column = 0;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            for (int i = 0; i < total; i++) {
                order[i] = matrix[row][column];
                visited[row][column] = true;
                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += directions[directionIndex][0];
                column += directions[directionIndex][1];
            }
            return order;
        }

        public static int reverse(int x) {
            if (x < 0) {
                String str1 = String.valueOf(x);
                char[] c2 = str1.toCharArray();
                char[] c3 = new char[c2.length];
                for (int i = c2.length - 1; i > 0; i--) {
                    c3[c2.length - 1 - i] = c2[i];
                }
                char[] c4 = new char[c3.length - 1];
                for (int i = 0; i < c4.length; i++) {
                    c4[i] = c3[i];
                }
                String str = new String(c4);
                Long t = Long.parseLong(str);
                if (-t < -Math.pow(2, 31)) {
                    return 0;
                } else {
                    return -t.intValue();
                }

            } else {
                String s = String.valueOf(x);
                char[] c = s.toCharArray();
                char[] c1 = new char[c.length];
                for (int i = c.length - 1; i >= 0; i--) {
                    c1[c.length - 1 - i] = c[i];
                }
                String s1 = new String(c1);
                Long y = Long.parseLong(s1);
                if (y > Math.pow(2, 31) - 1) {
                    return 0;
                } else {
                    return y.intValue();
                }
            }
        }

        public static int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            } else {
                Arrays.sort(nums);
                ArrayList<Integer> list = new ArrayList<>();
                int n = 1;
                int m = nums[0];
                list.add(n);
                for (int i = 1; i < nums.length; i++) {
                    if (m == nums[i]) {
                        continue;
                    } else if (m == nums[i] - 1) {
                        n++;
                        m = nums[i];
                        list.add(n);
                    } else {
                        n = 1;
                        list.add(n);
                        m = nums[i];
                    }
                }
                return Collections.max(list);
            }
        }

        public static int myAtoi(String str) {
            String s = str.trim();
            if (s.length() == 0 || s.equals("-") || s.equals("+")) {
                return 0;
            }
            char[] c = s.toCharArray();
            List<Character> list = new ArrayList<>();
            if (c[0] != '-' && c[0] != '+' && c[0] < '0' || c[0] > '9') {
                return 0;
            } else {
                list.add(c[0]);
            }
            for (int i = 1; i < c.length; i++) {
                if (c[i] >= '0' && c[i] <= '9') {
                    list.add(c[i]);
                } else {
                    break;
                }
            }
            int m = 0;
            if (list.get(0) == '-') {
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) == '0') {
                        m++;
                    } else {
                        break;
                    }
                }
                for (int i = m - 1; i > 0; i--) {
                    list.remove(i);
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == '0') {
                        m++;
                    } else {
                        break;
                    }
                }
                for (int i = m - 1; i >= 0; i--) {
                    list.remove(i);
                }
            }
            if (list.size() == 1 && (list.get(0) == '+' || list.get(0) == '-') || list.size() == 0) {
                return 0;
            }
            if (list.get(0) == '+') {
                list.remove(0);
            }
            char[] c1 = new char[list.size()];
            for (int i = 0; i < c1.length; i++) {
                c1[i] = list.get(i);
            }
            String str1 = new String(c1);
            if (list.get(0) == '-') {
                if (str1.length() > String.valueOf(Integer.MIN_VALUE).length()) {
                    return Integer.MIN_VALUE;
                } else if (str1.length() == String.valueOf(Integer.MIN_VALUE).length() && str1.compareTo(String.valueOf(Integer.MIN_VALUE)) > 0) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.parseInt(str1);
                }
            } else {
                if (str1.length() > String.valueOf(Integer.MAX_VALUE).length()) {
                    return Integer.MAX_VALUE;
                } else if (str1.length() == String.valueOf(Integer.MAX_VALUE).length() && str1.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.parseInt(str1);
                }
            }
        }

        public static boolean equationsPossible(String[] equations) {
            int length = equations.length;
            int[] parent = new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
            for (String str : equations) {
                if (str.charAt(1) == '=') {
                    int index1 = str.charAt(0) - 'a';
                    int index2 = str.charAt(3) - 'a';
                    union(parent, index1, index2);
                }
            }
            for (String str : equations) {
                if (str.charAt(1) == '!') {
                    int index1 = str.charAt(0) - 'a';
                    int index2 = str.charAt(3) - 'a';
                    if (find(parent, index1) == find(parent, index2)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static void union(int[] parent, int index1, int index2) {
            parent[find(parent, index1)] = find(parent, index2);
        }

        public static int find(int[] parent, int index) {
            while (parent[index] != index) {
                parent[index] = parent[parent[index]];
                index = parent[index];
            }
            return index;

        }

        public static int translateNum(int num) {
            int n = 0, m = 0, sum = 0;
            String str = String.valueOf(num);
            char[] ch = str.toCharArray();
            if (ch.length == 1) {
                return 1;
            } else {
                for (int i = 0; i < ch.length - 1; i++) {
                    if (ch[i] == '1' || (ch[i] == '2' && ch[i + 1] <= '5')) {
                        m++;
                    }
                    if (i + 1 != ch.length - 1 && (ch[i] == '1' && (ch[i + 1] == '1' || (ch[i + 1] == '2' && ch[i + 2] < '6')))) {
                        n++;
                    }
                    if (i + 1 != ch.length - 1 && (ch[i] == '2' && (ch[i + 1] == '1' || (ch[i + 1] == '2' && ch[i + 2] < '6')))) {
                        n++;
                    }
                }
                if (n == 0) {
                    return (int) Math.pow(2, m);
                } else {
                    return (int) Math.pow(2, m - n - 1) * Fibonacci(n + 2);
                }
            }
        }

        public static int Fibonacci(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 1;
            } else {
                return Fibonacci(n - 1) + Fibonacci(n - 2);
            }
        }

        public static boolean isPalindrome(int x) {
            String str = String.valueOf(x);
            if (str.length() == 0) {
                return true;
            }
            char[] ch1 = str.toCharArray();
            char[] ch2 = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                ch2[i] = ch1[str.length() - i - 1];
            }
            String str1 = new String(ch1);
            String str2 = new String(ch2);
            return str1.equals(str2);
        }

        public static int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }

        public static int[] dailyTemperatures(int[] T) {
            int[] t = new int[T.length];
            for (int i = 0; i < t.length; i++) {
                for (int j = i + 1; j < T.length; j++) {
                    if (T[j] > T[i]) {
                        t[i] = j - i;
                        break;
                    } else {
                        t[i] = 0;
                    }
                }
            }
            return t;
        }

        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list1.add(nums[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (list1.contains(-nums[i] - nums[j]) && list1.indexOf(-nums[i] - nums[j]) != i && list1.indexOf(-nums[i] - nums[j]) != j) {
                        list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], (-nums[i] - nums[j]))));
                    } else {
                        continue;
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                Collections.sort(list.get(i));
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = list.size() - 1; j > i; j--) {
                    if (list.get(i).equals(list.get(j))) {
                        list.remove(j);
                    }
                }
            }
            return list;
        }

        public static int climbStairs(int n) {
            return (int) ((int) 1 / Math.sqrt(5) * (Math.pow((1 + Math.sqrt(5)) / 2, n + 1) - Math.pow((1 - Math.sqrt(5)) / 2, n + 1)));
        }

        public static Map<Character, Integer> statistics(String str) {
            Map<Character, Integer> map = new HashMap<>();
            char[] ch = str.toCharArray();
            if (ch.length == 0) {
                return null;
            }
            for (int i = 0; i < ch.length; i++) {
                if (map.containsKey(ch[i])) {
                    int a = map.get(ch[i]);
                    a += 1;
                    map.put(ch[i], a);
                } else {
                    map.put(ch[i], 1);
                }
            }
            return map;
        }

        public static int findBestValue(int[] arr, int target) {
            Arrays.sort(arr);
            int a = 0;
            int[] replace1 = replace(arr, 0);
            int sum1 = sum(replace1);
            for (int i = 1; i <= arr[arr.length - 1]; i++) {
                int[] replace2 = replace(arr, i);
                int sum2 = sum(replace2);
                if (Math.abs(sum1 - target) > Math.abs(sum2 - target)) {
                    a = i;
                    sum1 = sum2;
                } else {
                    break;
                }
            }
            return a;
        }

        public static int sum(int[] arr) {
            int Sum = 0;
            for (int i = 0; i < arr.length; i++) {
                Sum += arr[i];
            }
            return Sum;
        }

        public static int[] replace(int[] arr, int target) {
            int[] a = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > target) {
                    a[i] = target;
                } else {
                    a[i] = arr[i];
                }
            }
            return a;
        }

        public static String compressString(String S) {
            if (S.length() == 0) {
                return S;
            }
            char[] ch = S.toCharArray();
            int a = 1;
            String str = "";
            char c = ch[0];
            for (int i = 1; i < ch.length; i++) {
                if (c == ch[i]) {
                    a++;
                } else {
                    str = str + c + a;
                    c = ch[i];
                    a = 1;
                }
            }
            str = str + c + a;
            return S.length() <= str.length() ? S : str;
        }

        public static void reverseString(char[] s) {
            char temp;
            for (int i = 0; i < s.length; i++) {
                if (i < s.length - 1 - i) {
                    temp = s[i];
                    s[i] = s[s.length - 1 - i];
                    s[s.length - 1 - i] = temp;
                } else {
                    break;
                }
            }
        }

        public static String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
            while (i >= 0 || j >= 0 || carry != 0) {
                if (i >= 0) carry += num1.charAt(i--) - '0';
                if (j >= 0) carry += num2.charAt(j--) - '0';
                sb.append(carry % 10);
                carry /= 10;
            }
            return sb.reverse().toString();
        }

        public static int compress(char[] chars) {
            int sum = 1;
            char ch = chars[0];
            String str = "";
            for (int i = 1; i < chars.length; i++) {
                if (ch == chars[i]) {
                    sum++;
                } else {
                    if (sum != 1) {
                        str = str + ch + sum;
                        ch = chars[i];
                        sum = 1;
                    } else {
                        str = str + ch;
                        ch = chars[i];
                        sum = 1;
                    }
                }
            }
            if (sum != 1) {
                str = str + ch + sum;
            } else {
                str = str + ch;
            }
            for (int i = 0; i < str.length(); i++) {
                chars[i] = str.charAt(i);
            }
            return str.length();
        }

        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            if (s1.equals(s2)) return true;
            s1 += s1;
            return s1.contains(s2);
        }

        public static int balancedStringSplit(String s) {
            int sum = 0;
            int i = 0;
            while (i < s.length() - 1) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    sum++;
                    i += 2;
                } else {
                    i++;
                }
            }
            return sum;
        }

        public static String longestCommonPrefix(String[] strs) {
            String str = "";
            if (strs.length == 0) {
                return str;
            }
            if (strs.length == 1) {
                return strs[0];
            }
            int i = 0;
            A:
            while (true) {
                for (int j = 0; j < strs.length - 1; j++) {
                    if (strs[j].length() == 0 || strs[j + 1].length() == 0) {
                        return str;
                    }
                    if (strs[j].length() > i && strs[j + 1].length() > i) {
                        if (strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                            continue;
                        } else {
                            break A;
                        }
                    } else {
                        break A;
                    }
                }
                if (strs[0].length() > i) {
                    str = str + strs[0].charAt(i);
                }
                i++;
            }
            return str;
        }

        public static String serialize(TreeNode root, String str) {
            if (root == null) {
                str = str + "null,";
            } else {
                str = str + str.valueOf(root.val) + ",";
                str = serialize(root.left, str);
                str = serialize(root.right, str);
            }
            return str;
        }

        public static String serialize(TreeNode root) {
            return serialize(root, "");
        }

        public static TreeNode deserialize(List<String> list) {
            if (list.get(0).equals("null")) {
                list.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = deserialize(list);
            root.right = deserialize(list);

            return root;
        }

        public static TreeNode deserialize(String data) {
            String[] str = data.split(",");
            List<String> list = new LinkedList<>(Arrays.asList(str));
            return deserialize(list);
        }

        public static int[] bubbleSort(int[] nums) {
            int temp;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 0; j < nums.length - 1 - i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
            return nums;
        }

        public static int maxScoreSightseeingPair(int[] A) {
            if (A.length == 0) {
                return 0;
            }
            int sum = 0;
            int i, max = 0;
            for (int j = 1; j < A.length; j++) {
                i = j - 1;
                if ((A[i] + i) > max) {
                    max = A[i] + i;
                }
                if ((max + A[j] - j) > sum) {
                    sum = max + A[j] - j;
                }
            }
            return sum;
        }

        public static int[] selectSort(int[] nums) {
            int temp;
            for (int i = 0; i < nums.length; i++) {
                temp = nums[i];
                for (int j = i; j < nums.length; j++) {
                    if (temp > nums[j]) {
                        temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                    }
                }
            }
            return nums;
        }

        public static int binarySearch(int[] nums, int num, int start, int end) {
            end = nums.length - 1;
            start = 0;
            int medium = (end - start) / 2;
            if (num == nums[medium]) {
                return medium;
            } else {
                if (num > nums[medium]) {
                    start = medium;
                    return binarySearch(nums, num, start, end);
                } else {
                    end = medium;
                    return binarySearch(nums, num, start, end);
                }
            }
        }

        public TreeNode recoverFromPreorder(String S) {
            return DFS(S, 0);
        }

        private int cursor = 0;

        public TreeNode DFS(String s, int level) {
            if (cursor >= s.length()) {
                return null;
            }
            if (s.charAt(cursor) == '-') {
                int count = cursor;
                while (s.charAt(count) == '-') {
                    count++;
                }
                if ((count - cursor) != level) {
                    return null;
                } else {
                    cursor = count;
                }
            }

            int num = 0;
            while (cursor < s.length() && s.charAt(cursor) >= '0' && s.charAt(cursor) <= '9') {
                int temp = s.charAt(cursor) - '0';
                num = num * 10 + temp;
                cursor++;
            }

            TreeNode root = new TreeNode(num);
            root.left = DFS(s, level + 1);
            root.right = DFS(s, level + 1);
            return root;
        }

        public static int[] insertSort(int[] nums) {
            int temp, current;
            //1,2,5,6,7,23,7,6,27,8,3,9,27,2
            for (int i = 1; i < nums.length; i++) {
                temp = i - 1;
                current = nums[i];
                while (temp >= 0 && nums[temp] > current) {
                    nums[temp + 1] = nums[temp];
                    temp--;
                }
                nums[temp + 1] = current;
            }
            return nums;
        }

        public static int[] quickSort(int[] nums, int low, int high) {
            //{1,2,5,6,7,23,7,6,27,8,3,9,27,2}
            int start = low;
            int end = high;
            int key = nums[low];

            while (end != start) {
                while (end > start && nums[end] >= key)
                    end--;
                if (nums[end] <= key) {
                    int temp = nums[end];
                    nums[end] = nums[start];
                    nums[start] = temp;
                }
                //System.out.println(Arrays.toString(nums) + end + " " + high + " " + low);

                while (end > start && nums[start] <= key)
                    start++;
                if (nums[start] >= key) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                }
                //System.out.println(Arrays.toString(nums) + start + " " + high + " " + low);
            }
            if (start > low) quickSort(nums, low, start - 1);
            if (end < high) quickSort(nums, end + 1, high);
            return nums;
        }

        public static int[] merge(int[] nums, int left, int medium, int right) {
            int[] temp = new int[nums.length];
            int p1 = left, p2 = medium + 1, k = left;

            while (p1 <= medium && p2 <= right) {
                if (nums[p1] <= nums[p2])
                    temp[k++] = nums[p1++];
                else
                    temp[k++] = nums[p2++];
            }

            while (p1 <= medium) temp[k++] = nums[p1++];
            while (p2 <= right) temp[k++] = nums[p2++];

            for (int i = left; i <= right; i++) {
                nums[i] = temp[i];
            }

            return nums;
        }

        public static int[] mergeSort(int[] nums, int start, int end) {
            int mid = (end + start) / 2;
            if (start < end) {
                mergeSort(nums, start, mid);
                mergeSort(nums, mid + 1, end);
                merge(nums, start, mid, end);
            }
            return nums;
        }

        public static boolean isPalindrome(String s) {
            if (s.length() == 0) return true;
            String s1 = s.toLowerCase();
            char[] chars = s1.toCharArray();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 'a' && chars[i] <= 'z'))
                    list.add(chars[i]);
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == list.get(list.size() - 1 - i)) continue;
                else return false;
            }
            return true;
        }

        public static boolean isMatch(String s, String p) {
            if (s == p) {
                return true;
            }
            if (s.isEmpty() && p.isEmpty()) {
                return true;
            }
            if (s.length() > 0 && p.length() == 0) {
                return false;
            }
            return match(s, s.length() - 1, p, p.length() - 1);
        }

        private static boolean match(String s, int si, String p, int pi) {
            char pc = p.charAt(pi);
            if (pc != '*') {
                if (si < 0) {
                    return false;
                }
                char sc = s.charAt(si);
                if (pc == sc || pc == '.') {
                    if (si == 0) {
                        if (pi == 0) {
                            return true;
                        } else {
                            return match(s, si - 1, p, pi - 1);
                        }
                    } else if (pi == 0) {
                        return false;
                    }
                    return match(s, si - 1, p, pi - 1);
                }
                return false;
            }
            if (si < 0) {
                if (pi == 1) {
                    return true;
                }
                return match(s, si, p, pi - 2);
            }
            char prepc = p.charAt(pi - 1);
            char sc = s.charAt(si);
            if (prepc == sc || prepc == '.') {
                if (match(s, si - 1, p, pi)) {
                    return true;
                }
                if (pi == 1) {
                    return false;
                }
                if (match(s, si, p, pi - 2)) {
                    return true;
                }
                return false;
            } else {
                if (pi == 1) {
                    return false;
                }
                return match(s, si, p, pi - 2);
            }
        }

        public static int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int best = 10000000;

            // 枚举 a
            for (int i = 0; i < n; ++i) {
                // 保证和上一次枚举的元素不相等
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 使用双指针枚举 b 和 c
                int j = i + 1, k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    // 如果和为 target 直接返回答案
                    if (sum == target) {
                        return target;
                    }
                    // 根据差值的绝对值来更新答案
                    if (Math.abs(sum - target) < Math.abs(best - target)) {
                        best = sum;
                    }
                    if (sum > target) {
                        // 如果和大于 target，移动 c 对应的指针
                        int k0 = k - 1;
                        // 移动到下一个不相等的元素
                        while (j < k0 && nums[k0] == nums[k]) {
                            --k0;
                        }
                        k = k0;
                    } else {
                        // 如果和小于 target，移动 b 对应的指针
                        int j0 = j + 1;
                        // 移动到下一个不相等的元素
                        while (j0 < k && nums[j0] == nums[j]) {
                            ++j0;
                        }
                        j = j0;
                    }
                }
            }
            return best;
        }

        public static boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }

        public static ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) return null;
            ListNode listNode = head;
            Set<Integer> set = new HashSet<>();
            while (listNode.next != null) {
                set.add(listNode.val);
                if (set.contains(listNode.next.val)) {
                    listNode.next = listNode.next.next;
                } else {
                    listNode = listNode.next;
                }
            }
            return head;
        }

        public static int firstMissingPositive(int[] nums) {
            int n = 1;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            while (set.contains(n)) {
                n++;
            }
            return n;
        }

        public static int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }

        public static int findLength(int[] A, int[] B) {
            int n = A.length, m = B.length;
            int[][] dp = new int[n + 1][m + 1];
            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }

        public static int kthSmallest(int[][] matrix, int k) {
            int[] temp = new int[matrix.length * matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    temp[i * matrix.length + j] = matrix[i][j];
                }
            }
            Arrays.sort(temp);
            return temp[k - 1];
        }

        public static int[] productExceptSelf(int[] nums) {
            int[] output = new int[nums.length];
            int a = 0;
            int num = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) a++;
                num *= nums[i];
            }
            if (a >= 2) {
                for (int i = 0; i < output.length; i++) {
                    output[i] = 0;
                }
            } else if (a == 1) {
                for (int i = 0; i < output.length; i++) {
                    if (nums[i] == 0) output[i] = multiply(nums, i);
                    else output[i] = 0;
                }
            } else {
                for (int i = 0; i < output.length; i++) {
                    output[i] = num / nums[i];
                }
            }
            return output;
        }

        public static int multiply(int[] nums, int k) {
            int num = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i == k) continue;
                else num *= nums[i];
            }
            return num;
        }

        public static TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        public static TreeNode helper(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = (left + right) / 2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid - 1);
            root.right = helper(nums, mid + 1, right);
            return root;
        }

        public int longestValidParentheses(String s) {
            int left = 0, right = 0, maxlength = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxlength = Math.max(maxlength, 2 * right);
                } else if (right > left) {
                    left = right = 0;
                }
            }
            left = right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxlength = Math.max(maxlength, 2 * left);
                } else if (left > right) {
                    left = right = 0;
                }
            }
            return maxlength;
        }

        public static boolean isMatch1(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int i = 1; i <= p.length(); i++) {
                if (p.charAt(i - 1) == '*') dp[0][i] = true;
                else break;
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) == '*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    if ((s.charAt(i - 1) == p.charAt(j - 1)) || p.charAt(j - 1) == '?')
                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
            return dp[s.length()][p.length()];
        }

        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int temp[] = new int[n];
            temp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        temp[j] = 0;
                        continue;
                    }
                    if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                        temp[j] += temp[j - 1];
                    }
                }
            }
            return temp[n - 1];
        }

        public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int temp[][] = new int[m][n];
            temp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        temp[i][j] = 0;
                        continue;
                    }
                    if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                        temp[i][j] += temp[i][j - 1];
                    }
                    if (i - 1 >= 0 && obstacleGrid[i - 1][j] == 0) {
                        temp[i][j] += temp[i - 1][j];
                    }
                }
            }
            return temp[m - 1][n - 1];
        }

        public static boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            int num = root.val;
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null && right == null) return sum == num;
            return hasPathSum(left, sum - num) || hasPathSum(right, sum - num);
        }

        public static int[] divingBoard(int shorter, int longer, int k) {
            int[] m = {};
            if (k == 0) return m;
            Set<Integer> set = new HashSet<>();
            int num = k / 2;
            for (int i = 0; i <= num; i++) {
                set.add(shorter * i + longer * (k - i));
                set.add(longer * i + shorter * (k - i));
            }
            int[] a = new int[set.size()];
            int i = 0;
            for (Integer integer : set) {
                a[i] = integer;
                i += 1;
            }
            Arrays.sort(a);
            return a;
        }

        public static List<Integer> countSmaller(int[] nums) {
            List<Integer> list = new LinkedList<>();
            int[] num = new int[nums.length];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < num.length; j++) {
                    if (nums[i] > nums[j]) num[i]++;
                }
            }
            for (int i = 0; i < num.length; i++) {
                list.add(num[i]);
            }
            return list;
        }

        public static int calculateMinimumHP(int[][] dungeon) {
            int n = dungeon.length, m = dungeon[0].length;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; ++i) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[n][m - 1] = dp[n - 1][m] = 1;
            for (int i = n - 1; i >= 0; --i) {
                for (int j = m - 1; j >= 0; --j) {
                    int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(minn - dungeon[i][j], 1);
                }
            }
            return dp[0][0];
        }

        public static int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> list = new LinkedList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    list.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            int[] num = new int[list.size()];
            for (int k = 0; k < list.size(); k++) {
                num[k] = list.get(k);
            }
            return num;
        }

        public static int numTrees(int n) {
            long C = 1;
            for (int i = 0; i < n; i++) {
                C = C * 2 * (2 * i + 1) / (i + 2);
            }
            return (int) C;
        }

        public static int numTrees1(int n) {
            if (n == 1) return 1;
            else return numTrees(n - 1) * 2 * (2 * n - 1) / (n + 1);
        }

        public static void BFS(TreeNode node) {
            if (node == null) {
                System.out.print("empty tree");
                return;
            }
            ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
            deque.add(node);
            while (!deque.isEmpty()) {
                TreeNode rnode = deque.remove();
                System.out.print(rnode.val + "  ");
                if (rnode.left != null) {
                    deque.add(rnode.left);
                }
                if (rnode.right != null) {
                    deque.add(rnode.right);
                }
            }
        }

        public static void DFS(TreeNode node) {
            if (node == null) {
                System.out.print("empty tree");
                return;
            }
            Stack<TreeNode> deque = new Stack<>();
            deque.push(node);
            while (!deque.isEmpty()) {
                TreeNode rnode = deque.pop();
                System.out.print(rnode.val + "  ");
                if (rnode.right != null) {
                    deque.add(rnode.right);
                }
                if (rnode.left != null) {
                    deque.add(rnode.left);
                }
            }
        }

        public static int searchInsert(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) return i;
            }
            return nums.length;
        }

        public static int[] twoSum1(int[] numbers, int target) {
            int index1 = 1;
            int index2 = numbers.length;
            int[] num = new int[2];
            while (index1 < index2) {
                if (numbers[index1 - 1] + numbers[index2 - 1] == target) {
                    num[0] = index1;
                    num[1] = index2;
                    break;
                } else if (numbers[index1 - 1] + numbers[index2 - 1] > target) {
                    index2--;
                } else index1++;
            }
            return num;
        }

        public static int minArray(int[] numbers) {
            Arrays.sort(numbers);
            return numbers[0];
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @SuppressWarnings("all")
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    @SuppressWarnings("all")
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            // 记录字符上一次出现的位置
            int[] last = new int[128];
            for (int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int n = s.length();

            int res = 0;
            int start = 0; // 窗口开始位置
            for (int i = 0; i < n; i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index] + 1);
                res = Math.max(res, i - start + 1);
                last[index] = i;
            }

            return res;
        }
    }
}

