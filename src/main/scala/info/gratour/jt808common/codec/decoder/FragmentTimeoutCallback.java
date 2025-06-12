/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec.decoder;

import info.gratour.jt808common.codec.decoder.fragment.CollectedFragment;

/**
 * 分片收集超时回调
 */
public interface FragmentTimeoutCallback {

    /**
     * 分片收集超时
     * @param collectedFragment 收集的分片
     */
    void onFragmentTimeout(CollectedFragment collectedFragment);
}
