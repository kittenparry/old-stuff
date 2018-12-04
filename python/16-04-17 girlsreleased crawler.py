import time
from bs4 import BeautifulSoup
import urllib.request
import dryscrape
import os

def sign():
    print('######################################')
    print('######################################')
    print('###  girlsreleased img downloader  ###')
    print('###                                ###')
    print('###                                ###')
    print('###                                ###')
    print('######################################')
    print('######################################')
agent = {'User-Agent': 'Mozilla/5.0'}
def replay():
    rp = input('#again? (y/n)')
    rp2 = rp.lower()
    if rp2 == 'y':
        crawl()
    elif rp2 == 'n':
        print('#shutting down')
    else:
        print('#type y or n')
        replay()
def crawl(mp = 1):
    galurl = input('#gallery url:')
    print('#checking the url')
    strippedurl = galurl.strip()
    splitgurl = strippedurl.split('.com', 1)
    first = splitgurl[0]
    if first == 'https://girlsreleased':
        second = splitgurl[1].split('=', 1)[0]
        if second == '/?setid':
            print('#done')
        else:
            print('#not a gallery link eg. /?setid=...')
            replay()
            return None
    else:
        print('#not a girlsreleased page')
        replay()
        return None
    page = 1
    foldername = strippedurl.split('=', 1)[1]
    path = foldername + '/'
    print('#checking for path ' + path)
    if not os.path.exists(path):
        os.makedirs(path)
    else:
        print('#path already exists')
        replay()
        return None
    print('#proceding..')
    session = dryscrape.Session()
    session.visit(strippedurl)
    response = session.body()
    soup = BeautifulSoup(response)
    while page <= mp:
        print('#getting galthumb')
        try:
            for galthumb in soup.findAll('div', {'class':'gallerythumbbox'}):
                print('#getting imghref')
                for img in galthumb.findAll('a'):
                    imghref = img.get('href')
                    get_imgs(imghref, path)
        except:
            print('##error')
        page += 1
def get_imgs(url, path, mp = 1):
    imghref = url
    page = 1
    print('#loading img page..')
    session = dryscrape.Session()
    session.visit(imghref)
    response = session.body()
    soup = BeautifulSoup(response)
    time.sleep(5)
    while page <= mp:
        print('#getting imglink')
        failcount = 0
        try:
            for imglink in soup.findAll('img', {'id': 'thepic'}):
                    print('#downloading img..')
                    root = imghref.split('img.php?', 1)[0]
                    name = str(imglink.get('alt'))
                    splitname = name.split('/', 2)[2]
                    pathname = path + splitname
                    src = root + imglink.get('src')
                    t = time.time()
                    urllib.request.urlretrieve(src, pathname)
                    t2 = str(time.time() - t)
                    t3 = t2[:4]
                    print('#downloaded ' + splitname)
                    print('#in ' + t3 + ' seconds')
                    print('#waiting..')
        except:
            failcount += 1
            print('#failed: total ' + str(failcount))
        page +=1
sign()
crawl()
