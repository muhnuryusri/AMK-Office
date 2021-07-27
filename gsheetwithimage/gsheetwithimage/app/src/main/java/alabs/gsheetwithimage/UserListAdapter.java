package alabs.gsheetwithimage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class UserListAdapter extends ArrayAdapter<String> {
    private  String[] NomorSpesifiks;
    private  String[] JenisAsetTetaps;
    private  String[] Gambars;
    private  Activity context;

    public UserListAdapter(Activity context, String[] NomorSpesifiks, String[] JenisAsetTetaps, String[] Gambars) {
        super(context, R.layout.list_row, NomorSpesifiks);
        this.context = context;
        this.NomorSpesifiks = NomorSpesifiks;
        this.JenisAsetTetaps = JenisAsetTetaps;
        this.Gambars = Gambars;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_row, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.tv_uid);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.tv_uname);
        ImageView iv = (ImageView)listViewItem.findViewById(R.id.imageView3);


        textViewId.setText(NomorSpesifiks[position]);
        textViewName.setText(JenisAsetTetaps[position]);
        // Uri uri = Uri.parse(uImages[position]);
        //Uri uri = Uri.parse("https://drive.google.com/uc?id=0B___GhMLUVtOY09SbDU5cDU2T1U");
        // draweeView.setImageURI(uri);

        Picasso.with(context).load(Gambars[position]).into(iv);

        return listViewItem;
    }
}