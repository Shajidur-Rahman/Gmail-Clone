package com.shajidurrahman.gmailclone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.shajidurrahman.MyApplicatiion;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<EmailModel> emailModels;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView textView2;
        private final ImageView EmailImage;
        private final ConstraintLayout constr;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.EmailTitle);
            textView2 = (TextView) view.findViewById(R.id.EmailDesc);
            EmailImage = (ImageView) view.findViewById(R.id.EmailStar);
            constr  = (ConstraintLayout) view.findViewById(R.id.constrainEmail);
        }

        public TextView getTextView() {
            return textView;
        }
        public TextView getTextView2() {
            return textView2;
        }
        public ImageView getImage() {
            return EmailImage;
        }
        public ConstraintLayout getConstr() {
            return constr;
        }
    }

    public CustomAdapter(List<EmailModel> dataSet) {
        emailModels = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.textviewl, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.getTextView().setText((CharSequence) emailModels.get(position));
        final EmailModel model = emailModels.get(position);
        viewHolder.getTextView().setText(model.getTitle());
        viewHolder.getTextView2().setText(model.getDesc());
//        viewHolder.getImage().setBackgroundResource(R.drawable.ic_menu_camera);
//        viewHolder.getImage().setImageResource(R.drawable.ic_menu_camera);

        viewHolder.getConstr().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApplicatiion.getAppContext(), EmailView.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MyApplicatiion.getAppContext().startActivity(intent);
                
            }
        });



        viewHolder.getImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ImageView test = (ImageView) viewHolder.getImage();
                final Bitmap bmap = ((BitmapDrawable)test.getDrawable()).getBitmap();
                Drawable myDrawable = test.getResources().getDrawable(R.drawable.star);
                final Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();

                if(bmap.sameAs(myLogo))
                {
                    viewHolder.getImage().setImageResource(R.drawable.starblack);
                } else {
                    viewHolder.getImage().setImageResource(R.drawable.star);
                }
            }
        });
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return emailModels == null ? 0 : emailModels.size();
    }
}
