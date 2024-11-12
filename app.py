import boto3
import datetime

s3 = boto3.client ("s3")

def lambda_handler(event, context):
    source_bucket = event["Records"][0]["s3"] ["bucket"]["name"]# type: ignore
    object_key = event["Records"][0]["s3"] ["bucket"]["name"]