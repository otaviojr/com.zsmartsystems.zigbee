/**
 * Copyright (c) 2016-2018 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
/*
   Copyright 2008-2013 ITACA-TSB, http://www.tsb.upv.es/
   Instituto Tecnologico de Aplicaciones de Comunicacion
   Avanzadas - Grupo Tecnologias para la Salud y el
   Bienestar (TSB)


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.zsmartsystems.zigbee.dongle.cc2531.network.packet.zdo;

import java.util.Arrays;

import com.zsmartsystems.zigbee.dongle.cc2531.network.packet.ResponseStatus;
import com.zsmartsystems.zigbee.dongle.cc2531.network.packet.ZToolCMD;
import com.zsmartsystems.zigbee.dongle.cc2531.network.packet.ZToolPacket;
import com.zsmartsystems.zigbee.dongle.cc2531.zigbee.util.DoubleByte;
import com.zsmartsystems.zigbee.dongle.cc2531.zigbee.util.ZToolAddress16;

/**
 * This callback indicates that Match Descriptor Response has been sent.
 *
 * @author <a href="mailto:alfiva@aaa.upv.es">Alvaro Fides Valero</a>
 */
public class ZDO_MATCH_DESC_REQ extends ZToolPacket /* implements IRESPONSE_CALLBACK,IZDo */ {
    /// <name>TI.ZPI1.ZDO_MATCH_DESC_REQ.NumInClusters</name>
    /// <summary>The number of Input Clusters provided for matching within the InClusterList.</summary>
    private int NumInClusters;
    /// <name>TI.ZPI1.ZDO_MATCH_DESC_REQ.InClusterList</name>
    /// <summary>List of Input ClusterIDs to be used for matching; the InClusterList is the desired list to be matched by the Remote Device (the elements of the InClusterList are the supported output clusters of the Local Device).</summary>
    private int[] InClusterList;
    /// <name>TI.ZPI1.ZDO_MATCH_DESC_REQ.OutClusterList</name>
    /// <summary>List of Output ClusterIDs to be used for matching; the OutClusterList is the desired list to be matched by the Remote Device (the elements of the OutClusterList are the supported input clusters of the Local Device).</summary>
    private int[] OutClusterList;
    /// <name>TI.ZPI1.ZDO_MATCH_DESC_REQ.NumOutClusters</name>
    /// <summary>The number of Output Clusters provided for matching within the OutClusterList.</summary>
    private int NumOutClusters;
    /// <name>TI.ZPI1.ZDO_MATCH_DESC_REQ.NWKAddrOfInterest</name>
    /// <summary>Device's short address of the request</summary>
    private ZToolAddress16 NWKAddrOfInterest;
    /// <name>TI.ZPI1.ZDO_MATCH_DESC_REQ.SrcAddress</name>
    /// <summary>the message's source network address</summary>
    private ZToolAddress16 SrcAddress;
    /// <name>TI.ZPI1.ZDO_MATCH_DESC_REQ.ProfileId</name>
    /// <summary>Profile ID to be matched at the destination.</summary>
    private int ProfileId;

    /// <name>TI.ZPI1.ZDO_MATCH_DESC_RSP</name>
    /// <summary>Constructor</summary>
    public ZDO_MATCH_DESC_REQ() {
        this.InClusterList = new int[0xff];
        this.OutClusterList = new int[0xff];
    }

    public ZDO_MATCH_DESC_REQ(int[] framedata) {
        this.SrcAddress = new ZToolAddress16(framedata[1], framedata[0]);
        this.NWKAddrOfInterest = new ZToolAddress16(framedata[3], framedata[2]);
        this.ProfileId = framedata[4];
        this.NumInClusters = framedata[5];
        this.InClusterList = new int[this.NumInClusters];
        int i;
        for (i = 0; i < this.InClusterList.length; i++) {
            this.InClusterList[i] = framedata[i + 6];
        }
        this.NumOutClusters = framedata[i+7];
        for (int j = 0; j < this.InClusterList.length; j++) {
            this.InClusterList[i] = framedata[i + 8 + j];
        }
        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_MATCH_DESC_REQ), framedata);
    }

    @Override
    public String toString() {
        return "ZDO_MATCH_DESC_REQ{" + "NumInClusters=" + NumInClusters + ", NumOutClusters=" + NumOutClusters + ", InClusterList="
                + Arrays.toString(InClusterList) + ", OutClusterList=" + Arrays.toString(OutClusterList) + ", NWKAddrOfInterest=" + NWKAddrOfInterest + ", SrcAddress="
                + SrcAddress + ", ProfileId=" + ProfileId + '}';
    }
}
