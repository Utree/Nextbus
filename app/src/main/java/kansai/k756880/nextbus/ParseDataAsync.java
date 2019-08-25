package kansai.k756880.nextbus;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * ParseDataAsync
 *
 * 非同期でWebページからバスの運行情報を取得するクラス
 */
public class ParseDataAsync extends AsyncTask<Void, Void, String> {
    /** コールバックタスクのインスタンス */
    private CallBackTask callBackTask;

    @Override
    protected String doInBackground(Void... aVoid) {
        StringBuilder result = new StringBuilder();

        try {
            /** リクエスト先URL */
            URL url = new URL("https://transfer.navitime.biz/takatsuki/pc/location/BusLocationResult?startId=00150093&goalId=00150029");
//            URL url = new URL("https://c9c509b6.ngrok.io/");
            /** コネクション */
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            /** インプットストリーム */
            InputStream in = urlConnection.getInputStream();
            /** ストリームリーダー */
            InputStreamReader inReader = new InputStreamReader(in);
            /** バッファリーダー */
            BufferedReader bufReader = new BufferedReader(inReader);

            String line;
            // 1行ずつテキストを読み込む
            while((line = bufReader.readLine()) != null) {
                result.append(line);
            }

            bufReader.close();
            inReader.close();
            in.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {callBackTask.CallBack(result);}
    public void setOnCalBack(CallBackTask t_object) { callBackTask = t_object; }
    // コールバック用のインターフェース定義
    interface CallBackTask{ void CallBack(String result); }
}
