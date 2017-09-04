package test.hk.com.KkDriving.been;

/**
 * Created by 1 on 2017/4/18.
 */
// "id": 12,
//        "question": "这个标志是何含义？",//问题
//        "answer": "4",//答案
//        "item1": "前方40米减速",//选项，当内容为空时表示判断题正确选项
//        "item2": "最低时速40公里",//选项，当内容为空时表示判断题错误选项
//        "item3": "限制40吨轴重",
//        "item4": "限制最高时速40公里",
//        "explains": "限制最高时速40公里：表示该标志至前方限制速度标志的路段内，机动车行驶速度不得超过标志所示数值。此标志设在需要限制车辆速度的路段的起点。以图为例：限制行驶时速不得超过40公里。",//答案解释
//        "url":
//    {"id":"22",
// "question":"驾驶人驾驶有达到报废标准嫌疑机动车上路的，交通警察依法予以拘留。",
// "answer":"2",
// "item1":"正确",
// "item2":"错误",
// "item3":"",
// "item4":"",
// "explains":"交警只能扣留车辆，还没达到拘留的地步。",
// "url":""}

public class TestData {
    public  int id,answer;

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String question,item1,item2,item3,item4,explains,imgurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public String getItem4() {
        return item4;
    }

    public void setItem4(String item4) {
        this.item4 = item4;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
