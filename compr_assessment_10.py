from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
import time
import pytest
import unittest


driver = webdriver.Chrome()
driver.get("https://autify.com")
driver.maximize_window()
time.sleep(10)
# handles = driver.window_handles 
# for i in handles: 
    # driver.switch_to.window(i) 
# driver.find_element(By.XPATH, value='//button[@id="CybotCookiebotDialogBodyButtonDecline"]').click()
# time.sleep(10)
driver.find_element(By.XPATH,value='//img[@class="drop-down-arrow"]').click()
time.sleep(10)
driver.find_element(By.XPATH,value='//a[@href="https://nocode.autify.com/"]//*[@alt="Autify Nocode Image Logo"]').click()
time.sleep(10)
handles1 = driver.window_handles 
for i in handles1: 
    driver.switch_to.window(i) 
driver.find_element(By.XPATH, value='//button[@data-cky-tag="accept-button"]').click()
time.sleep(10)
# driver.find_element(By.LINK_TEXT,"Autify NoCode Mobile").click()


def test_check_Url_moble():
 driver.find_element(By.XPATH, value='//a[@href="/mobile"]').click()
# actual_url = driver.current_url
 actual_url = driver.current_url
 print("The current url is:"+str(actual_url))
 assert "https://nocode.autify.com/mobile" in actual_url
time.sleep(10)
#driver.find_element(By.LINK_TEXT,"Autify NoCode Web").click()

driver.find_element(By.XPATH, value='//a[@href="/"][contains(text(),"Autify NoCode Web")]').click()
actual_url2 = driver.current_url
print("The current url2 is:"+str(actual_url2))
def test_check_Url_web():

 assert "https://nocode.autify.com/" in driver.current_url


time.sleep(10)
