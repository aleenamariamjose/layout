package com.example.speakout;

public class Member {
    String memberId;
    String MemberName;
    public Member(){

    }

    public Member(String memberId, String memberName) {
        this.memberId = memberId;
        MemberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return MemberName;
    }
}
