# 1. requests 라이브러리 가져오기
import requests

# 2. url 요청 보내자
url = 'https://api.bithumb.com/public/ticker/btc'

# 3. 값을 받아오자
response = requests.get(url).json()
print(response['data']['max_price'])