package kansai.k756880.nextbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ParseDataAsync.CallBackTask {
    /** ListViewが参照するデータを格納するためのArrayList */
    ArrayList<DepartureData> list = new ArrayList<>();
    /** ListViewのアダプター */
    ListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** ListViewのid */
        ListView listView = findViewById(R.id.listView);

//        ListAdapterを初期化
        myAdapter = new ListAdapter(MainActivity.this);
//        Listに表示するためのリストを設定
        myAdapter.setDepartureList(list);
//        ListViewへアダプターを設定
        listView.setAdapter(myAdapter);

        getData();
    }

    public void getData() {
        // インスタンスを作成
        ParseDataAsync parseData = new ParseDataAsync();
        // コールバックを設定
        parseData.setOnCalBack(this);
        // 実行
        parseData.execute();
    }

    @Override
    public void CallBack(String result) {
        /** レスポンスをJsoupでパースしたもの */
        Document doc = Jsoup.parse(result);
//        listViewが参照しているArrayListを全件削除
        list.clear();

        for (Element element : doc.getElementsByClass("plotList")) {
            /** データクラスのインスタンス */
            DepartureData tmp = new DepartureData();

//            レスポンスからパースして形成
            tmp.setDestination(element.getElementsByClass("courseSummary").text());
            tmp.setDepartureTime(element.getElementsByClass("on-time").text());
            tmp.setRemainingTime(element.getElementsByClass("minutes-to-arrival").text());
            tmp.setDelay(element.getElementsByClass("delay-minutes-are").text());
            tmp.setWhereIs(element.getElementsByClass("approach-number").text());

//            listViewが参照しているArrayListへ代入
            list.add(tmp);
        }

//        ListViewのアダプターへ変更を通知
        myAdapter.notifyDataSetChanged();

    }
}
