package com.example.crimereport1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CrimeListFragment extends Fragment {

    private  class  CrimeHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextViewl;
        private TextView mDateTextView;
        private ImageView mImageView;

        private  Crime mCrime;



        public  CrimeHolder(LayoutInflater inflater, ViewGroup parent){
            super( inflater.inflate(R.layout.list_item_crime,parent,false));

             mTitleTextViewl = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
            mImageView = (ImageView) itemView.findViewById(R.id.crime_solved);


            itemView.setOnClickListener(this);

        }
        public void bind(Crime crime) {
            mCrime = crime;
            mTitleTextViewl.setText(crime.getTitle());
            mDateTextView.setText(crime.getDate().toString());
            mImageView.setVisibility(mCrime.isSolved() == true ? View.VISIBLE : View.GONE);

        }

        @Override
        public void onClick(View v) {
//            Toast.makeText(getActivity(),mCrime.getTitle().toUpperCase(),Toast.LENGTH_LONG).show();

//            Intent intent = CrimeActivity.newIntent(getActivity() , mCrime.getId());
            Intent intent = CrimePagerActivity.newIntent(getActivity() , mCrime.getId());

            startActivity(intent);


        }
    }

    private class  CrimeAdapter extends  RecyclerView.Adapter<CrimeHolder> {

        private List<Crime> mCrime;


        public CrimeAdapter(List<Crime> mCrime) {
            this.mCrime = mCrime;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater  = LayoutInflater.from(getActivity());


            return new CrimeHolder(inflater , parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime = mCrime.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return mCrime.size();
        }
    }

    private RecyclerView mCrimeRecylerView;
    private CrimeAdapter crimeAdapter;

    @Override
    public void onResume() {
        super.onResume();
        updateID();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_list_cime,container,   false);

        mCrimeRecylerView =  (RecyclerView ) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    
        
        updateID();




        return view;

    }

    private void updateID() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());

        List<Crime> crimes = crimeLab.getCrimes();

        if(crimeAdapter == null) {

        crimeAdapter  = new CrimeAdapter(crimes);

        mCrimeRecylerView.setAdapter(crimeAdapter);
        }
        else
            crimeAdapter.notifyDataSetChanged();
    }
}
