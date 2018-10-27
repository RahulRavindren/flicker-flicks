package com.flickerflics.interfaces;

/**
 * @Author rahulravindran
 */
public interface ViewHolderType {
    void onBindData(final Object value, final int position);

    void onAttach();

    void onDetach();

    void onDestory();
}
