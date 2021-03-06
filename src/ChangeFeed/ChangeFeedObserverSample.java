package ChangeFeed;
/*
 * The MIT License (MIT)
 * Copyright (c) 2018 Microsoft Corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import com.microsoft.azure.cosmosdb.Document;
import com.microsoft.azure.cosmosdb.SerializationFormattingPolicy;
import com.microsoft.azure.cosmosdb.changefeedprocessor.ChangeFeedObserver;
import com.microsoft.azure.cosmosdb.changefeedprocessor.ChangeFeedObserverCloseReason;
import com.microsoft.azure.cosmosdb.changefeedprocessor.ChangeFeedObserverContext;

import java.util.List;

/**
 * Sample ChangeFeedObserver.
 */
public class ChangeFeedObserverSample implements ChangeFeedObserver {
    @Override
    public void open(ChangeFeedObserverContext context) {
        System.out.println("--->SampleObserverImpl::open()");
        return;
    }

    @Override
    public void close(ChangeFeedObserverContext context, ChangeFeedObserverCloseReason reason) {
        System.out.println("--->SampleObserverImpl::close() -> " + reason.name());
        return;
    }

    @Override
    public void processChanges(ChangeFeedObserverContext context, List<Document> docs) {
        System.out.println("--->SampleObserverImpl::processChanges() START");

        for (Document document : docs) {
            System.out.println("---->DOCUMENT RECEIVED: " + document.toJson(SerializationFormattingPolicy.Indented));
        }
        System.out.println("--->SampleObserverImpl::processChanges() END");

        return;
    }
}


