package com.example.leetcode.test;

import java.util.*;

public class s355 {

    public static void main(String[] args) {

    }

//    设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
//
//    postTweet(userId, tweetId): 创建一条新的推文
//    getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
//    follow(followerId, followeeId): 关注一个用户
//    unfollow(followerId, followeeId): 取消关注一个用户
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/design-twitter
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




}



class Twitter {

    static int timestamp = 0;

    static class User{
        private int id;
        public Set<Integer> followed;
        // 用户发表的推文链表头结点
        public Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            // 关注一下自己
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            // 不可以取关自己
            if (userId != this.id)
                followed.remove(userId);
        }

        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            // 将新建的推文插入链表头
            // 越靠前的推文 time 值越大
            twt.next = head;
            head = twt;
        }
    }

    static class Tweet{
        private int id;
        private int time;
        private Tweet next;

        // 需要传入推文内容（id）和发文时间
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    // 我们需要一个映射将 userId 和 User 对象对应起来
    private HashMap<Integer, User> userMap = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User newuser = new User(userId);
            userMap.put(userId, newuser);
        }
        User cur = userMap.get(userId);
        cur.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)){
            return res;
        }
        PriorityQueue<Tweet> q = new PriorityQueue<>((a,b) -> b.time - a.time);
        User cur = userMap.get(userId);
        Set<Integer> followed = cur.followed;
        for (Integer id : followed) {
            Tweet twt = userMap.get(id).head;
            if (twt!=null){
                q.offer(twt);
            }
        }

        while (!q.isEmpty()){
            if (res.size()==10) {
                break;
            }
            Tweet twt = q.poll();
            res.add(twt.id);
            if (twt.next!=null) {
                q.offer(twt.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User follower = new User(followerId);
            userMap.put(followerId, follower);
        }
        if (!userMap.containsKey(followeeId)) {
            User followee = new User(followeeId);
            userMap.put(followeeId, followee);
        }
        User follower = userMap.get(followerId);
        follower.follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User follower = userMap.get(followerId);
            follower.unfollow(followeeId);
        }
    }
}



//class Twitter {
//
//    static int timestamp = 0;
//    static class Tweet{
//
//    }
//    static class User{
//
//    }
//
//    static HashMap<Integer, User> map = new HashMap<>();
//
//    /** Initialize your data structure here. */
//    public Twitter() {
//
//    }
//
//    /** Compose a new tweet. */
//    public void postTweet(int userId, int tweetId) {
//
//    }
//
//    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
//    public List<Integer> getNewsFeed(int userId) {
//
//    }
//
//    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
//    public void follow(int followerId, int followeeId) {
//
//    }
//    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
//    public void unfollow(int followerId, int followeeId) {
//
//    }
//
//
//
//}