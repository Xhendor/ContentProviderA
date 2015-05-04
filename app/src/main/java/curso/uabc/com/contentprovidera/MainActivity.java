package curso.uabc.com.contentprovidera;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
    private static final Uri URI_CP = Uri.parse(
            "content://curso.uabc.com.test/clientes");
    private String nombre;
    private int telefono;
    private String email;
    private Cursor c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        ContentResolver CR = getContentResolver();
        String[] valores_recuperar = { "nombre", "telefono", "email"};

       c= CR.query(URI_CP,valores_recuperar,null,null,null);
        c.moveToFirst();
        do {
            nombre = c.getString(0);
            telefono = c.getInt(1);
            email = c.getString(2);
            System.err.println("QUERY:["+ nombre + ", " + telefono + ", " + email+" ]");
        } while (c.moveToNext());

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

}
