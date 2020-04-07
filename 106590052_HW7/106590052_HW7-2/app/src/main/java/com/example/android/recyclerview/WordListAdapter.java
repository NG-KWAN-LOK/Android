/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Shows how to implement a simple Adapter for a RecyclerView.
 * Demonstrates how to add a click handler for each item in the ViewHolder.
 */
public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.RecipeViewHolder> {

    private final LinkedList<String> mRecipeName;
    private final LinkedList<String> mRecipeDesc;
    private LayoutInflater mLayoutInflater;
    public final static String EXTRA_NAME = "com.example.android.recyclerview.EXTRA.NAME";

    WordListAdapter(Context context, LinkedList<String> recipeName, LinkedList<String> recipeDesc){
        mLayoutInflater = LayoutInflater.from(context);
        this.mRecipeName = recipeName;
        this.mRecipeDesc = recipeDesc;
    }

    @NonNull
    @Override
    public WordListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mLayoutInflater.inflate(R.layout.recipe_list, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.RecipeViewHolder holder, int position) {
        String mCurrentName = mRecipeName.get(position);
        String mCurrentDesc = mRecipeDesc.get(position);
        holder.recipeNameTextView.setText(mCurrentName);
        holder.recipeDescTextView.setText(mCurrentDesc);
    }

    @Override
    public int getItemCount() {
        return mRecipeName.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView recipeNameTextView;
        final TextView recipeDescTextView;
        final WordListAdapter mAdapter;

        RecipeViewHolder(View itemView, WordListAdapter adapter){
            super(itemView);
            recipeNameTextView = itemView.findViewById(R.id.item_title);
            recipeDescTextView = itemView.findViewById(R.id.item_desc);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mRecipeName.get(mPosition);
            Intent intent = new Intent(v.getContext(), WordMethodActivity.class);
            Bundle extra = new Bundle();
            extra.putString(EXTRA_NAME, element);
            intent.putExtras(extra);
            v.getContext().startActivity(intent);
        }
    }
}
