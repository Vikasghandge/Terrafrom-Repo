import boto3
import datetime

s3 = boto3.client ("s3")

def lambda_handler(event, context):
    source_bucket = event # type: ignore