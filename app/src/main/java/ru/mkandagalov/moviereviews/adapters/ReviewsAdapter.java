package ru.mkandagalov.moviereviews.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ru.mkandagalov.moviereviews.R;
import ru.mkandagalov.moviereviews.models.Result;

/**
 * Created by Марат on 03.02.2018.
 */

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {
    private List<Result> mData;
    private Context mContext;
    private OnItemClickListener mOnClickListener;

    public ReviewsAdapter(Context context, List<Result> data, OnItemClickListener listener) {
        this.mData = data;
        this.mContext = context;
        this.mOnClickListener = listener;
    }

    public interface OnItemClickListener {
        void onClick(String url);
    }

    @Override
    public ReviewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_cardview, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ReviewsAdapter.ViewHolder holder, final int position) {
        holder.titleTextView.setText(mData.get(position).getDisplayTitle());
        holder.publicationTextView.setText(mData.get(position).getPublicationDate());
        holder.reviewTextVIew.setText(mData.get(position).getHeadline());
        holder.reviewSummaryTextView.setText(mData.get(position).getSummaryShort());
        holder.reviewTagTextView.setText(mData.get(position).getMpaaRating());
        holder.readMoreTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClickListener.onClick(mData.get(position).getLink().getUrl());
            }
        });

        String images = mData.get(position).getMultimedia().getSrc();

        Glide.with(mContext)
                .load(images)
                .into(holder.reviewImage);

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView reviewCard;
        TextView titleTextView, publicationTextView, reviewTextVIew, reviewSummaryTextView, reviewTagTextView, readMoreTextView;
        ImageView reviewImage;

        public ViewHolder(View itemView) {
            super(itemView);
            reviewCard = itemView.findViewById(R.id.review_card);
            titleTextView = itemView.findViewById(R.id.review_title);
            publicationTextView = itemView.findViewById(R.id.review_publication_time_text);
            reviewTextVIew = itemView.findViewById(R.id.review_text);
            reviewSummaryTextView = itemView.findViewById(R.id.review_short_summary);
            reviewTagTextView = itemView.findViewById(R.id.review_tag_text);
            readMoreTextView = itemView.findViewById(R.id.read_more);
            reviewImage = itemView.findViewById(R.id.review_image);
        }
    }
}
